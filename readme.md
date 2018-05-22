http://localhost:8080/RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons


# RegistratieSysteem

# Person information
GET All persons
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons

GET specific person
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}?type=id
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{licenseplate}?type=plainplate
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{hashedlicenseplate}?type=hashedplate

POST Insert a specific person
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons

PUT Update a specific person
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons

GET A vehicles of a user
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}/vehicles

PUT Add a vehicle to a user
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}/vehicles/{plainTextPlate}
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}/vehicles/{hashedPlate}

DELETE Delete a vehicle of a user
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}/vehicles/{plainTextPlate}
- RekeningAdministratieSysteem-1.0-SNAPSHOT/api/persons/{id}/vehicles/{hashedPlate}


