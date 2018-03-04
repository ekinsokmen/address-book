# Structure

## Model
Model keeps the Person object. Model object provides type safety for other layers.

## Data
Data provides the list of persons. It will read the file based person list in next version.

## Service
Service includes implementation on top of the list of persons. The logic to answer the questions will be implemented in service layer.

## View
View layer will provide the interaction between user and the services.

# Status
This version includes the implementation of service layer. There is a hard coded Person list provider for testing. 
Data layer and view layer is not implemented yet.