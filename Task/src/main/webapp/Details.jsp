<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        /* Background Styling */
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: url('https://png.pngtree.com/thumb_back/fh260/background/20230715/pngtree-school-classroom-with-chalkboard-and-desk-in-3d-rendering-image_3850971.jpg') no-repeat center center/cover;
            color: #fff;
        }

        /* Dark Overlay */
        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
            z-index: -1;
        }

        /* Container Styling */
        .container {
            text-align: center;
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
            animation: fadeIn 1.5s ease;
        }

        /* Heading and Details Styling */
        h1 {
            font-size: 2em;
            margin-bottom: 20px;
            color: #4CAF50;
        }

        p {
            font-size: 1.2em;
            margin: 10px 0;
        }

        /* Back Button Styling */
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 24px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1em;
            transition: transform 0.3s ease, background-color 0.3s ease;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
        }

        /* Hover and Active States for Back Button */
        .back-button:hover {
            background-color: #45a049;
            transform: scale(1.05);
        }

        .back-button:active {
            transform: scale(0.95);
        }

        /* Fade-In Animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Details</h1>
        <%
            // Retrieve attributes from the request
            String name = (String) request.getAttribute("name");
            String email = (String) request.getAttribute("email");
            String phoneNo = (String) request.getAttribute("phone_no");

            if (name != null && email != null && phoneNo != null) {
        %>
            <p><strong>Name:</strong> <%= name %></p>
            <p><strong>Email:</strong> <%= email %></p>
            <p><strong>Phone Number:</strong> <%= phoneNo %></p>
        <% 
            } else { 
        %>
            <p>User details not found.</p>
        <% 
            } 
        %>
        <a href="home.jsp" class="back-button">Back</a>
    </div>
</body>
</html>
