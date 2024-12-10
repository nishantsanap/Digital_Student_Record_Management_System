<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <style>
        
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: url('https://png.pngtree.com/thumb_back/fh260/background/20230715/pngtree-school-classroom-with-chalkboard-and-desk-in-3d-rendering-image_3850971.jpg') no-repeat center center/cover;
            position: relative;
            color: #fff;
            text-align: center;
        }
        
        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
            z-index: 1;
        }
        
        .headline {
            position: relative;
            z-index: 2;
            font-size: 2.5em;
            font-weight: bold;
            margin-bottom: 30px;
            animation: fadeInDown 1.5s ease-out;
        }
        @keyframes fadeInDown {
            0% {
                opacity: 0;
                transform: translateY(-20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        .action-links {
            position: relative;
            z-index: 2;
            display: flex;
            gap: 15px;
            margin-top: 20px;
        }
        
        .action-links a {
            padding: 12px 24px;
            text-decoration: none;
            font-size: 1em;
            font-weight: bold;
            color: white;
            border-radius: 8px;
            position: relative;
            overflow: hidden;
            background-color: #4CAF50;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }
        .action-links a:hover {
            transform: scale(1.05);
            box-shadow: 0 0 15px rgba(76, 175, 80, 0.5);
        }
    
        .action-links a:nth-child(1) { background-color: #4CAF50; } /* View Profile */
        .action-links a:nth-child(2) { background-color: #ff9800; } /* Update Profile */
        .action-links a:nth-child(3) { background-color: #f44336; } /* Delete Account */
        .action-links a:nth-child(4) { background-color: #2196F3; } /* Logout */

        /*  Animation */
        .action-links a::after {
            content: "";
            position: absolute;
            top: 0;
            left: -100%;
            width: 200%;
            height: 100%;
            background: rgba(255, 255, 255, 0.3);
            transform: skewX(-20deg);
            transition: left 0.5s;
        }
        .action-links a:hover::after {
            left: 100%;
        }
        
        .notification {
            display: none;
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
            z-index: 3;
        }
    </style>
</head>
<body>
   <%-- <h1 class="headline" id="greeting">Student Dashboard</h1> --%>
    
    <h1 class="headline" id="greeting">Student Dashboard</h1>
    <div class="action-links">
        <% String phoneNo = (String) request.getAttribute("phone_no"); %>
        <a href="details?phone_no=<%= phoneNo %>">View Profile</a>
        <a href="edit?phone_no=<%= phoneNo %>">Update Profile</a>
        <a href="delete?phone_no=<%= phoneNo %>" onclick="confirmDelete(event)">Delete Account</a>
        <a href="login.html" onclick="logout(event)">Logout</a>
    </div>

    
    <div class="notification" id="notification">You have logged out successfully!</div>

    <script>
        // Dynamic Greeting based on time of day
        <%--const greetingElement = document.getElementById('greeting');
        const hours = new Date().getHours();
        let greetingMessage = 'Welcome';
        
        if (hours < 12) {
            greetingMessage = 'Good Morning';
        } else if (hours < 18) {
            greetingMessage = 'Good Afternoon';
        } else {
            greetingMessage = 'Good Evening';
        }
        greetingElement.innerText = `${greetingMessage}, Student Dashboard`; --%>

        // Confirm Delete Function
        function confirmDelete(event) {
            if (!confirm("Are you sure you want to delete your account? ")) {
                event.preventDefault();
            }
        }

        // Logout Function with Notification
        function logout(event) {
            event.preventDefault(); 
            const notification = document.getElementById('notification');
            notification.style.display = 'block';
            setTimeout(() => {
                notification.style.display = 'none';
                window.location.href = 'login.html'; // Redirect to login page
            }, 4000); // notification for 2 second
        }
    </script>
</body>
</html>
