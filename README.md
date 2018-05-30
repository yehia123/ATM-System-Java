# ATM System - Object Oriented Design


Academic project to design a basic ATM system for a bank to allow the user the to withdraw and deposit money into his account. 
The data structure used here is an Array

# Account.java
-- Account object for the users, contains name, balance, card #, expiration date.
-- Basic get and set methods to update and retreive information from the object.
-- toString method to display the object in the command line

# Bank.java
-- Contains data structures using ArrayList()
-- authroizeATM() function is used to double check if the program contains object with the correct numbers
-- withdraw updates object if it has enough amount 

# ATMSystem.java
-- Main class
-- Uses simple system.out.print commands to prompt the user
-- User input is taken using a scanner
-- After authorization the user is able to withdraw/deposit money into the account (object)
