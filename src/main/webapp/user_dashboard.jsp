<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="user_dashboard">Docalendar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse d-flex flex-row-reverse" id="navbarNav">
            <ul class="navbar-nav"> 
                <li class="nav-item">
                    <a class="nav-link" href="./index.jsp">Log out</a>
                </li> 
            </ul>
        </div>
    </nav>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="border-bottom d-flex col-md-12 justify-content-between mb-2">
                <h3>Scheduled appointments</h3>
                <a href="./user_schedule_appointment.jsp" class="text-primary align-self-center justify-self-center">
                    Make new appointment
                </a>
            </div>
            <div class="col-md-12 w-100">
                <div class="card"> 
                    <div class="card-body d-flex justify-content-between">
                        <div>
							<a href="UserAppointment">Appointment</a>
                        </div>
                    </div>
                    
                    <div class="card-footer text-muted">
                        <!-- add ng link para sa process files -->

                        <!-- removed user_dashboard access for marked as done. Cause the doctor should decide that, and to prevent accidental done appointments -->
                        <!-- <button type="submit" class="btn btn-success">Mark as done</button> -->
                        <button type="submit" class="btn btn-danger">Cancel Appointment</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
