| **Component**   | **Preconditions**                   | **Actual**       |
|-----------------|-------------------------------------|------------------|
| **Java**        | 1.8 or newer                        | 21               |
| **Selenium**    | 3.141.59 or newer                   | 4.17.0           |
| **Runner**      | JUnit/TestNG - Not specified        | TestNG - 7.13.0  |
| **Rest**        | OkHttp3/Apache Http - Not specified | OkHttp3 - 4.12.0 |
| **Logging**     | SLF4J, Log4j - Not specified        | Log4j - 2.23.1   |
| **Cucumber**    | Not specified                       | 7.13.0           |
| **AssertJ**     | Not specified                       | 3.24.2           |
| **Spring Boot** | Not specified                       | 3.2.1            |
| **Jackson**     | Not specified                       | 2.17.1           |

---
Case 1 – Automate Purchase Process

1. Open the url: https://www.saucedemo.com/inventory.html
2. Create a credential.json file in test/resources folder and store:
   {
   username: performance_glitch_user,
   password: secret_sauce
   }
3. Parse the credentials from credential.json and use it for the following test
4. On the website type username and password and click on login button
5. Add the following items to the cart: Sauce Labs Backpack, Sauce Labs Fleece Jacket
6. Validate the number on the cart symbol
7. Go through the checkout process
8. Validate that Thank you for your order message is appearing

---

Case 2 – Verify error messages for mandatory fields

1. Open the url: https://www.saucedemo.com/inventory.html
2. Click on login button
3. Validate the error message
4. Login with the following credentials: standard_user / secret_sauce
5. Scroll down to the bottom of the page
6. Validate the footer message contains 2025 and Terms of Service

---
Case 3 - Rich Text Editor

1. Open the url: https://onlinehtmleditor.dev
2. Type the following text to the editor: Automation Test Example
3. Automation text should be typed bold format
4. Test text should be typed underline format
5. Validate the text is appearing in the rich text editor

---
Case 4 - iFrame and tab handling

1. Open the URL http://demo.guru99.com/test/guru99home
2. Below the text: ‘iFrame will not show if you have adBlock extension enabled’ find the iFrame.
3. Click on the image inside it
4. Close the new tab that opens
5. Find the Email Submission text. Fill out the field below it and click the Submit button.
6. Validate that the popup message contains the text ‘Successfully
7. On the navigation menu, click on Selenium dropdown and choose the Tooltip option.
8. Validate the tooltip page contains the Download now button

---
Case 5 – REST API testing

1. Add Rest Api library for the test project
2. Create and send request:  
   Request type: GET
   Host: https://jsonplaceholder.typicode.com  
   Endpoint: /users
3. Parse response to Json format (It is by default - I parsed into a pojo instead)
4. Log only the names and emails from the response data  
   Example:  
   Leanne Graham | Sincere@april.biz
   Ervin Howell | Shanna@melissa.tv
5. Verify the first email address contains @

---

Location of the tests: src/main/resources/features/scenarios.feature


   Don’t forget to upload your code to GitHub!
