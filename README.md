# CRUD App with Spring Boot
The code written here is for requirements as provided in description section below

## Requirements

- Maven
- JDK 8

Implement a software library that allows you to create, read, update and delete (CRUD) the example objects in a relational (SQL) database.
This library should have a programming interface (API).
The objects form a simple hierarchy of one-to-many relationships: 

	device -> qubit -> gate

Implement the ability to easily move up or down the hierarchy given an instance of one of the objects.
E.g. given a qubit you should be able to get the device the qubit is on and get the gates for that qubit.

Implement versioning of the qubits and gates
