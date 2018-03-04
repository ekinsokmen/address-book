# Structure

## Model
Model keeps the Person object. Model object provides type safety for other layers.

## Data
Data provides the list of persons. The implementation to read person data from file is included in this layer.

## Service
Service includes implementation on top of the list of persons. The logic to answer the questions will be implemented in service layer.

## View
View layer provides the interaction between user and the services.

### Console Based View Implementation
Run following commands to *ask the questions*:
```
> mvn package

# How many males are in the address book?
> mvn exec:java -Dexec.args="AddressBook ShowNumberOfPersonsByGender Male"

# Who is the oldest person in the address book?
> mvn exec:java -Dexec.args="AddressBook ShowOldestPerson"

# How many days older is Bill than Paul?
> mvn exec:java -Dexec.args="AddressBook ShowAgeDiffInDays Bill Paul"
```