<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>STUDYSPHERE</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to STUDYSPHERE!</h1>
        <p>Please enter your contact information:</p>
        <form action="contact" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="contactMethod">Preferred Contact Method:</label>
            <select id="contactMethod" name="contactMethod" required>
                <option value="">Select...</option>
                <option value="email">Email</option>
                <option value="phone">Phone</option>
                <option value="chat">Chat</option>
            </select>

            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
