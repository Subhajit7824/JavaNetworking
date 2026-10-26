Java TCP Client-Server Communication

A simple TCP Client-Server application implemented in Java using Socket and ServerSocket. This project demonstrates how a client and server communicate over a TCP connection by exchanging text messages.

📌 Project Overview

This project implements a basic client-server communication model using Java's built-in networking APIs.

The server listens for incoming client connections on port 5000. Once a client connects, it can send messages to the server. The server reads each message, displays it in the console, and sends an acknowledgment response back to the client.

The communication continues until the client sends exit, which terminates the session.

✨ Features
TCP Communication: Establishes a reliable connection between a client and a server.
Socket Programming: Uses Java's Socket and ServerSocket classes.
Real-Time Messaging: Allows the client to send messages and receive server responses.
Message Acknowledgment: The server acknowledges each message received.
Graceful Session Termination: Ends the communication loop when the client sends exit.
Resource Management: Uses Java's try-with-resources statement to automatically close sockets and streams.
🛠️ Technologies Used
Programming Language: Java
Networking: TCP/IP Socket Programming
Input/Output: BufferedReader, InputStreamReader, and PrintWriter
Port: 5000
📂 Project Structure
text
Java-TCP-Client-Server/
├── TcpServer.java
├── TcpClient.java
└── README.md

⚙️ Prerequisites

Before running the project, ensure that you have:

Java Development Kit (JDK) installed.
A terminal or command prompt.
Basic knowledge of Java and computer networking.

Verify your Java installation:

bash
java -version
javac -version

🚀 Getting Started
1. Clone the Repository

If the project is hosted on GitHub, clone it using:

bash
git clone <your-repository-url>


Navigate to the project directory:

bash
cd Java-TCP-Client-Server


Alternatively, download the source files and open the project in your preferred Java IDE.

2. Compile the Source Files

Compile both Java files:

bash
javac TcpServer.java TcpClient.java


This generates the corresponding .class files.

3. Start the Server

Open a terminal and run:

bash
java TcpServer


Expected output:

text
TCP Server started on port 5000
Waiting for a client...


The server is now waiting for a client connection.

4. Start the Client

Open a second terminal in the same project directory and run:

bash
java TcpClient


Expected output:

text
Connected to TCP server!
Type a message, or 'exit' to quit.


The client connects to the server running on localhost at port 5000.

5. Exchange Messages

Type a message in the client terminal:

text
Hello Server


The client receives:

text
Server reply: Server received: Hello Server


On the server terminal, the message appears as:

text
Client Connected!
Client says: Hello Server


You can continue exchanging messages in the same way.

6. Terminate the Connection

Type the following in the client terminal:

text
exit


The server acknowledges the message, and both sides exit their communication loops. The sockets and associated streams are closed automatically.

🔄 How It Works

The application follows a simple request-response communication model.

Server initialization: TcpServer creates a ServerSocket on port 5000.
Client connection: TcpClient creates a Socket connecting to localhost:5000.
Connection acceptance: The server uses accept() to wait for and accept an incoming client connection.
Message transmission: The client reads input from the keyboard and sends each message through its output stream.
Message reception: The server reads incoming messages using BufferedReader.
Server response: The server replies with Server received: <message>.
Session termination: When the client sends exit, both communication loops terminate and their resources are closed.
🧠 Key Java Networking Classes
Class	Purpose
ServerSocket	Listens for incoming TCP connections on a specified port.
Socket	Establishes a TCP connection between the client and server.
BufferedReader	Reads text input efficiently from streams.
InputStreamReader	Converts incoming bytes into characters.
PrintWriter	Sends text messages through the socket output stream.

The PrintWriter is configured with autoFlush enabled, so calls to println() automatically flush the output.

📡 Communication Model
text
       TCP Client                         TCP Server
           |                                  |
           |------ Connection Request ------->|
           |<--------- Connection Accepted ---|
           |                                  |
           |-------- "Hello Server" --------->|
           |                                  |
           |<-- "Server received: Hello Server"|
           |                                  |
           |----------- "exit" -------------->|
           |<-------- Exit acknowledgment ----|
           |                                  |
           |          Connection Ends         |

⚠️ Limitations
The server handles one client connection at a time.
The server accepts only one connection per execution because it calls accept() only once.
The client connects to localhost, so it is intended to run on the same machine as the server.
The application exchanges plain-text messages without encryption or authentication.
Error handling is basic and prints stack traces when exceptions occur.
🔮 Future Improvements

Possible enhancements include:

Support multiple clients using threads or an ExecutorService.
Allow the client to connect to a configurable server IP address and port.
Add better exception handling and connection status messages.
Implement a graphical user interface (GUI).
Add message timestamps and structured logging.
Secure communication using TLS/SSL.
Support file transfer between the client and server.
🎯 Learning Objectives

This project helps demonstrate:

The fundamentals of TCP/IP communication.
The difference between client and server sockets.
How to establish and manage socket connections in Java.
How to send and receive data using input and output streams.
How to implement a basic request-response protocol.
👨‍💻 Author

Your Name

GitHub: Your GitHub Profile
📄 License

This project is available for educational and learning purposes. Add a license such as the MIT License if you intend to distribute it as an open-source project.