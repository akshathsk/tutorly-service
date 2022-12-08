<html>
<head>
    <style>
        .icon {
            height: 110px;
            width: 120px;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .outset {
            border-style: outset;
            width: 40%;
        }

        body {background-color: whitesmoke;}

        .white {
            background-color: white;
        }

        .blue {
            background-color: #e8f3f8;
        }

        .center {
            margin: auto;
            width: 40%;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="outset center blue">

    <div class="white">
        <img class="icon" src="https://i.ibb.co/VqNvCm2/tutorly.jpg" alt="Tutorly" />
    </div>
    <p>Dear ${student},</p>
    <br/>
    <p><b>Your session with ${tutor} has been confirmed!</b></p>
    <br/>
    <br/>
    <p><b>Slot Details:</b></p>
    <p>&emsp; <b>Date:</b> ${slotDate}</p>
    <p>&emsp; <b>Time:</b> ${startTime} to ${endTime}</p>
    <br/>
    <p><b>You can reach your tutor by:</b></p>
    <p>&emsp; <b>Email:</b> ${email}</p>
    <p>&emsp; <b>Phone:</b> ${phone}</p>
    <br/>
    <br/>
    <p>Thanks!</p>
    <br/>
    <p>Best regards,</p>
    <p>Tutorly Admin Team</p>
    <br/>
    <hr />
    <p><small>Have questions or need help? Email us at <a href="mailto:${adminEmail}">${adminEmail}</a></small></p>
</div>
</body>
</html>
