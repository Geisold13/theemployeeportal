export interface CreateEmployeeRequest {

  employee: {
    firstName: String;
    middleName: String;
    lastName: String;
    email: String;
    phoneNumber: String;
    state: String;
    city: String;
    zipCode: String;
    streetAddress: String;
    jobTitle: String;
    dateOfHire: Date;
    status: String;
  };

}
