# =============================
# CONFIGURACIÓN DEL PROYECTO
# =============================

BASE_PACKAGE = com.medicalteachingcoordination
SRC_MAIN = src/main/java
SRC_TEST = src/test/java

# =============================
# COMANDOS PRINCIPALES
# =============================

help:
	@echo "Uso:"
	@echo "  make build                               - Compila el proyecto"
	@echo "  make run                                 - Ejecuta el proyecto"
	@echo "  make test                                - Corre los tests"
	@echo "  make javadoc                             - Genera documentacion Javadoc"
	@echo "  make newclass NAME=paquete/Clase         - Crea una nueva clase"
	@echo "  make newinterface NAME=paquete/Interfaz  - Crea una nueva interfaz"
	@echo "  make newtest NAME=paquete/Clase          - Crea un test JUnit 5"
	@echo "  make new NAME=paquete/Clase              - Crea clase + test"

build:
	mvn compile

run:
	mvn exec:java

test:
	mvn test

# =============================
# GENERAR JAVADOC
# =============================

javadoc:
	@echo "Eliminando Javadoc previo..."
	@if [ -d "target/site/apidocs" ]; then rm -rf target/site/apidocs; fi
	@echo "Generando nuevo Javadoc..."
	mvn -q clean javadoc:javadoc
	@echo "Javadoc generado en: target/site/apidocs/index.html"

# =============================
# FUNCIONES AUXILIARES
# =============================

CLASS_NAME = $(notdir $(NAME))
RELATIVE_PKG = $(dir $(NAME))
PACKAGE_SUFFIX = $(shell echo $(RELATIVE_PKG) | sed 's/\//./g' | sed 's/\.$$//')
FULL_PACKAGE = $(BASE_PACKAGE)$(if $(PACKAGE_SUFFIX),.$(PACKAGE_SUFFIX))

CLASS_DIR = $(SRC_MAIN)/$(subst .,/,$(FULL_PACKAGE))
TEST_DIR = $(SRC_TEST)/$(subst .,/,$(FULL_PACKAGE))

CLASS_FILE = $(CLASS_DIR)/$(CLASS_NAME).java
TEST_FILE = $(TEST_DIR)/$(CLASS_NAME)Test.java

# =============================
# CREAR NUEVA CLASE
# =============================

newclass:
ifndef NAME
	$(error Falta el nombre: use 'make newclass NAME=paquete/Clase')
endif
	@if [ -f "$(CLASS_FILE)" ]; then \
		echo "La clase $(CLASS_NAME) ya existe en el paquete $(FULL_PACKAGE)."; \
	else \
		mkdir -p "$(CLASS_DIR)"; \
		echo "package $(FULL_PACKAGE);" > $(CLASS_FILE); \
		echo "" >> $(CLASS_FILE); \
		echo "public class $(CLASS_NAME) {" >> $(CLASS_FILE); \
		echo "    public $(CLASS_NAME)() {" >> $(CLASS_FILE); \
		echo "        // Constructor basico" >> $(CLASS_FILE); \
		echo "    }" >> $(CLASS_FILE); \
		echo "}" >> $(CLASS_FILE); \
		echo "Clase creada: $(CLASS_FILE)"; \
	fi

# =============================
# CREAR NUEVA INTERFAZ
# =============================

newinterface:
ifndef NAME
	$(error Falta el nombre: use 'make newinterface NAME=paquete/Interfaz')
endif
	@if [ -f "$(CLASS_DIR)/$(CLASS_NAME).java" ]; then \
		echo "La interfaz $(CLASS_NAME) ya existe en el paquete $(FULL_PACKAGE)."; \
	else \
		mkdir -p "$(CLASS_DIR)"; \
		echo "package $(FULL_PACKAGE);" > $(CLASS_DIR)/$(CLASS_NAME).java; \
		echo "" >> $(CLASS_DIR)/$(CLASS_NAME).java; \
		echo "public interface $(CLASS_NAME) {" >> $(CLASS_DIR)/$(CLASS_NAME).java; \
		echo "    // Metodos de la interfaz" >> $(CLASS_DIR)/$(CLASS_NAME).java; \
		echo "}" >> $(CLASS_DIR)/$(CLASS_NAME).java; \
		echo "Interfaz creada: $(CLASS_DIR)/$(CLASS_NAME).java"; \
	fi

# =============================
# CREAR NUEVO TEST
# =============================

newtest:
ifndef NAME
	$(error Falta el nombre: use 'make newtest NAME=paquete/Clase')
endif
	@if [ -f "$(TEST_FILE)" ]; then \
		echo "El test $(CLASS_NAME)Test ya existe."; \
	else \
		mkdir -p "$(TEST_DIR)"; \
		echo "package $(FULL_PACKAGE);" > $(TEST_FILE); \
		echo "" >> $(TEST_FILE); \
		echo "import org.junit.jupiter.api.Test;" >> $(TEST_FILE); \
		echo "import static org.junit.jupiter.api.Assertions.*;" >> $(TEST_FILE); \
		echo "" >> $(TEST_FILE); \
		echo "public class $(CLASS_NAME)Test {" >> $(TEST_FILE); \
		echo "    @Test" >> $(TEST_FILE); \
		echo "    void testConstructor() {" >> $(TEST_FILE); \
		echo "        $(CLASS_NAME) obj = new $(CLASS_NAME)();" >> $(TEST_FILE); \
		echo "        assertNotNull(obj);" >> $(TEST_FILE); \
		echo "    }" >> $(TEST_FILE); \
		echo "}" >> $(TEST_FILE); \
		echo "Test creado: $(TEST_FILE)"; \
	fi

# =============================
# CREAR CLASE + TEST
# =============================

new: newclass newtest
