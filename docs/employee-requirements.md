# Employee Requirements:

    Employee Fields Spring Boot:
    
    Field Name: employeeId;
    Data Type: long
    Access Modifier: private
    Database column name: employee_id

    Field Name: firstName
    Data Type: String
    Access Modifier: private
    Database column name: first_name

    Field Name: middleName
    Data Type: String
    Access Modifier: private
    Database column name: middle_name

    Field Name: lastName
    Data Type: String  
    Access Modifier: private
    Database column name: last_name

    Field Name: email
    Data Type: String
    Access Modifier: private
    Database column name: email

    Field Name: phoneNumber
    Data Type: String
    Access Modifier: private
    Database column name: phone_number

    Field Name: state
    Data Type: String
    Access Modifier: private
    Database column name: state

    Field Name: city
    Data Type: String
    Access Modifier: private
    Database column name: city

    Field Name: zipCode
    Data Type: String
    Access Modifier: private
    Database column name: zip_cde

    Field Name: streetAddress
    Data Type: String
    Access Modifier: private
    Database column name: street_address

    Field Name: jobTitle
    Data Type: String
    Access Modifier: private
    Database column name: job_title

    Field Name: dateOfHire
    Data Type: LocalDate
    Access Modifier: private
    Database column name: date_of_hire

    Field Name: dateOfTermination
    Data Type: LocalDate
    Access Modifier: private
    Database column name: date_of_termination

    Field Name: status
    Data Type: String
    Access Modifier: private
    Database column name: status

    Field Name:
    Data Type:
    Access Modifier:
    Database column name:

    Field Name:
    Data Type:
    Access Modifier:
    Database column name:

    Field Name:
    Data Type:
    Access Modifier:
    Database column name:

    Field Name:
    Data Type:
    Access Modifier:
    Database column name:


    Employee Fields Angular:

    

# Universal Rules for ALL Employee Fields

    Rules:
        Not Null: Yes
        Not Blank: Yes

# Field Specific Rules

## First Name, Last Name

    Rules:
        Required: yes
        Min-Characters: 2
        Max-Characters: 50
        Spaces Allowed: yes
        Characters Allowed: Only a-z and A-Z, ' -
        Characters Restrictions: Everything that is not a letter
        Character regex angular: /^[A-Za-z]+(?:[ '-][A-Za-z]+)*$/

## Middle Name
    
    Rules:
        Required: yes
        Default = N/A
        Min-Characters: 2
        Max-Characters: 50  
        Spaces Allowed: yes
        Characters Allowed: Only a-z and A-Z, ' - 
        Character Restrictions: Everything that is not a letter
        Character regex angular: /^[A-Za-z]+(?:[ '-][A-Za-z]+)*$/

        
## Email

    Rules:
        Required: yes
        format: email format domain@something.com
        Min-Characters: 6
        Max-Characters: 254
        Characters Allowed: a-z A-Z 0-9 . (period) _ (underscore) - (hyphen)
        Character Restrictions: ! " # $ % & ' ( ) * , / : ; < = > ? [ \ ] ^ ` { | } ~
                                and any characters not shown in Characters Allowed
        
## Phone Number

    Rules:
        Required: yes
        user input format: XXX-XXX-XXXX or XXXXXXXXXX
        Restrictions: USA only
        Min-Characters: 10
        Max-Characters: 12 (includes two possible hyphens user inputs)
        Characters Allowed: 0-9 - 
        Character Restrictions: Every character that is not a number
        Angular Regex: /^\d{3}-?\d{3}-?\d{4}$/

## State
    
    Rules:
        Required: yes
        format: State Abreviation ## - preselected dropdown list
        Restrictions: USA State only
        Min-Characters: N/A
        Max-Characters: N/A
        
## City
    
    Rules:
        Required: yes
        Restrictions: Needs to be valid US city
        Min-Characters: 2
        Max-Characters: 50
        Spaces Allowed: yes (no leading or trailing)
        Characters Allowed: a-z A-Z ' - . 
        Character Restrictions: All characters not listed in Characters Allowed
        Angular Regex: /^[A-Za-z]+(?:[ .'-][A-Za-z]+)*$/
## Zip Code
    
    Rules:
        Required: yes
        Format: #####
        Restrictions: Needs to be valid US zip code
        Min-Characters: 5
        Max-Characters: 5
        Spaces allowed: no, no leading, no trailing
        Characters Allowed: 0-9
        Character Restrictions: All characters that are not a number
        Angular Regex: /^\d{5}$/

# Street Address
        
    Rules:
        Required: yes
        Restrictions: Needs to be a valid street address
        Min-Characters: 2
        Max-Characters: 100
        Spaces Allowed: no
        Characters Allowed: a-z A-Z 0-9 . - ' # / ,
        Character Restrictions: All characters that are not list in Characters Allowed
        Angular Regex: /^[A-Za-z0-9]+(?:[ .,'#/-][A-Za-z0-9]+)*$/

## Job Title
        
    Rules:
        Required: yes
        Restrictions: Pre-selected dropdown list
        Min-Characters: 3
        Max-Characters: 50
        Spaces Allowed: yes
        Characters Allowed: a-z A-Z 0-9
        Character Restrictions: All characters that are not listed in Characters Allowed

## Date of Hire

    Rules: 
        Required: yes
        Format:
        Restrictions: Date Picker (valid date)
        Min-Characters: N/A
        Max-Characters: N/A
        Spaces Allowed: no
        Characters Allowed: N/A
        Character Restrictions: N/A

## Date of Termination

    Rules: 
        Required: no
        Format:
        Restrictions: Date Picker (valid date)
        Default: N/A
        Min-Characters: N/A
        Max-Characters: N/A
        Spaces Allowed: no
        Characters Allowed: N/A
        Character Restrictions: N/A
        
 ## Status

    Rules: 
        Required: yes
        Default: N/A
        Restrictions: preselected dropdown list
         Min-Characters: N/A
        Max-Characters: N/A
        Spaces Allowed: no
        Characters Allowed: N/A
        Character Restrictions: N/A


