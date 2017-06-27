<%-- 
    Document   : add-new
    Created on : Jun 27, 2017, 3:31:48 PM
    Author     : kimaiga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grantee Data</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
        <!--fonts-->
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/app.css">
        <!--font-awesome-->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="large-8 large-centered columns">
                    <h4>Add new grantee Data</h4>
                    <hr>
                    <form autocomplete="off" name="grantees">
                        <fieldset>
                            <label>Full Names</label>
                            <input type="text" name="grantee-name" placeholder="Names">
                        </fieldset>
                        <fieldset>
                            <label>Year</label>
                            <select id="selectElementId"></select>
                        </fieldset>
                        <fieldset>
                            <label>Issue</label>
                            <input type="text" name="issue" placeholder="Names">
                        </fieldset>
                        <fieldset>
                            <label>Program</label>
                            <select name="program">
                                <option value="Grand Challenges Africa">Grand Challenges Africa</option>
                                <option value="H3-Africa">H3-Africa</option>
                                <option value="Deltas Africa">Deltas Africa</option>
                                <option value="Circle Africa">Circle Africa</option>
                            </select>
                        </fieldset>
                        <fieldset>
                            <label>Amount</label>
                            <input type="number" name="amount" placeholder="Amount">
                        </fieldset>
                        <button type="submit" class="button primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <script>
            var min = new Date().getFullYear(),
                    max = min + 9,
                    select = document.getElementById('selectElementId');

            for (var i = min; i <= max; i++) {
                var opt = document.createElement('option');
                opt.value = i;
                opt.innerHTML = i;
                select.appendChild(opt);
            }
        </script>
    </body>
</html>
