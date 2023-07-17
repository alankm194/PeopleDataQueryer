# People Queries Application

This is a Command line application to query people data from a CSV file source


## Data format
the input file must have the follow data format

| Header       | Data format | example                   |
|--------------|-------------|---------------------------| 
| first_name   | String      | John                      |
| last_name    | String      | doe                       |
| company_name | String      | john company              |
| address      | String      | 123 main str              |
| city         | String      | Glasgow                   |
| county       | String      | Lanarkshire               |
| postal       | String      | G4 123                    |
| phone1       | String      | 01473-229124              |
| phone2       | String      | 01541-802635              |
| email        | String      | johndoe@myfakermail.com   |
| web          | String      | www.webjohn.com           |



## Usage
The CLI will ask you for the file location of the file you wish to query and give 
you the following options 

1. Include only people who have Esq in their company name
2. Include only people who only live in Derbyshire
3. Include only people who have a house number that has 3 digits
4. Include only people who have a website that is larger than 35 characters
5. Include only people who has only 1 digit in the first part of their post code
6. Include only people who has a phone 1 numerically larger than phone 

Please choose the number corresponding to the option you wish to select. 



