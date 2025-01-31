help:
	@echo "Available commands"
	@echo "     make run        - run spring boot"
	@echo "     make install    - maven clean and install"
	@echo "     make tests      - run unit tests"

run:
	./mvnw spring-boot:run

install:
	./mvnw clean install

tests:
	./mvnw test