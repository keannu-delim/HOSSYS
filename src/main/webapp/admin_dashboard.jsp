<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-success">
        <a class="navbar-brand" href="#">Docalendar Admin</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse d-flex flex-row-reverse" id="navbarNav">
            <ul class="navbar-nav"> 
                <li class="nav-item">
                    <a class="nav-link" href="./admin_login.jsp">Log out</a>
                </li> 
            </ul>
        </div>
    </nav>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="border-bottom d-flex col-md-12 justify-content-between mb-2">
                <h3>Upcoming appointments</h3>
                <a href="./admin_finished_appointments.jsp" class="text-secondary underline align-self-center justify-self-center">
                    Finished appointments
                </a>
            </div>

            <div class="col-md-12 w-100">
                <div class="card"> 
                    <a href='Appointment'>Appointments:</a>
                </div>
                    <div class="card-footer text-muted">
                        <!-- add ng link para sa process files -->
                        <button type="submit" class="btn btn-success">Mark as done</button>
                        <button type="submit" class="btn btn-secondary">Reschedule Appointment</button>
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
