# Introduction
The purpose of this project is to convert a match time and match period from one format to another.\
e.g.

| Input      | Expected Output |
| ----------- | ----------- |
| "[PM] 0:00.000"      | "00:00 – PRE_MATCH"       |
| "[H1] 0:15.025"   | "00:15 – FIRST_HALF"        |
| "[H1] 3:07.513"   | "03:08 – FIRST_HALF"        |
| "[H1] 45:00.001"   | "45:00 +00:00 – FIRST_HALF"        |
| "[H1] 46:15.752"   | "45:00 +01:16 – FIRST_HALF"        |
| "[HT] 45:00.000"   | "45:00 – HALF_TIME"        |
| "[H2] 45:00.500"   | "45:01 – SECOND_HALF"        |
| "[H2] 90:00.908"   | "90:00 +00:01 – SECOND_HALF"        |
| "[FT] 90:00.000"   | "90:00 – FULL_TIME"        |
| "90:00"   | "INVALID"        |
| "[H3] 90:00.000"   | "INVALID"        |
| "[PM] -10:00.000"   | "INVALID"        |
| "FOO"   | "INVALID"        |

#How to use it?
- In the GitHub repository you can download the jar file (StringConverter-1.0.jar) from the src\target location \
full location: https://github.com/eternalgooner/ppb-string-converter/tree/master/target

- save the jar file in your desired location, e.g. C:\dev

- open a command line window and navigate to the location where the jar file is saved, e.g. cd C:\dev

- 

#Test data
you can save this test data into a .txt file and use with the program

[PM] 0:00.000\
[H1] 0:15.025\
[H1] 3:07.513\
[H1] 45:00.001\
[H1] 46:15.752\
[HT] 45:00.000\
[H2] 45:00.500\
[H2] 90:00.908\
[FT] 90:00.000\
90:00\
[H3] 90:00.000\
[PM] -10:00.000\
FOO\
---------
#more stuff
test

