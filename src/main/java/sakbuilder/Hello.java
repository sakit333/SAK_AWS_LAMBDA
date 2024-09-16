// package sakbuilder;
// import com.amazonaws.services.lambda.runtime.Context;
// import com.amazonaws.services.lambda.runtime.RequestHandler;

// /**
//  * Represents a simple Lambda function that returns a hardcoded string.
//  */
// // public class Hello {
    
// //     public String handleRequest() {
// //         return "i am sakbuilder";
// //     }
// // }

// public class Hello implements RequestHandler<Object, String> {
//     public String handleRequest(final Object input, final Context context) {
//         System.out.println(input);
//         return context.getLogGroupName();
//         // return "Hello from Lambda!";
//     }
// }