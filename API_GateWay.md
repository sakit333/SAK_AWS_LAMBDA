# Saving the provided markdown content to a .md file

markdown_content = """
# AWS Lambda with Java and API Gateway Setup Guide

## Step 1: Modify the Lambda Code to Accept Input from API Gateway

1. Update the `HelloLambda.java` file to accept an input as a JSON object:

   ```java
   // HelloLambda.java
   package com.example;

   import com.amazonaws.services.lambda.runtime.Context;
   import com.amazonaws.services.lambda.runtime.RequestHandler;
   import java.util.Map;

   public class HelloLambda implements RequestHandler<Map<String, String>, String> {
       @Override
       public String handleRequest(Map<String, String> input, Context context) {
           String name = input.get("name");
           return "Hello, " + name + "!";
       }
   }
   ```

   - This code expects a JSON object with a key `"name"`. Example input:
     ```json
     {
       "name": "John"
     }
     ```

## Step 2: Build and Deploy the JAR File

1. **Build the JAR File**:
   - If using Maven, run:
     ```bash
     mvn clean package
     ```
   - This generates the JAR file in the `target` directory.

2. **Upload the JAR File** to your AWS Lambda function:
   - Go to the AWS Lambda Console, upload the new JAR, and set the handler to:
     ```
     com.example.HelloLambda::handleRequest
     ```

## Step 3: Set Up API Gateway

1. **Go to API Gateway Console**:
   - Navigate to the API Gateway service in the AWS Console.

2. **Create a New REST API**:
   - Choose **REST API** (not HTTP API) and click **Build**.
   - **API Name**: Enter a name (e.g., `HelloLambdaAPI`).

3. **Create a New Resource and Method**:
   - In the API Gateway console, click **Actions** and select **Create Resource**.
   - Name the resource (e.g., `/greet`), and then create a method (e.g., **POST**).
   - In the **Integration Type**, choose **Lambda Function**.
   - **Select your Lambda Function** (e.g., `HelloLambda`).

4. **Deploy the API**:
   - Click **Actions** again and select **Deploy API**.
   - Choose a deployment stage (e.g., **prod**).

## Step 4: Test the API URL

1. Once deployed, API Gateway will give you an **Invoke URL**. It should look like:
   ```
   https://<your-api-id>.execute-api.<region>.amazonaws.com/prod/greet
   ```

2. **Test the API**:
   - Use a tool like Postman or `curl` to send a POST request:
     ```bash
     curl -X POST -H "Content-Type: application/json" -d '{"name": "John"}' https://<your-api-id>.execute-api.<region>.amazonaws.com/prod/greet
     ```

   - The response should be:
     ```
     Hello, John!
     ```
"""

# Save to a markdown file
file_path = '/mnt/data/AWS_Lambda_Java_API_Gateway_Setup_Guide.md'
with open(file_path, 'w') as file:
    file.write(markdown_content)

file_path