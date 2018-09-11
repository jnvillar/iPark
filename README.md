# iPark
[https://ipark-api.herokuapp.com/](https://ipark-api.herokuapp.com/)

iPark is a restApi who's objective is to manage free parking lots on the street. iPark accomplishes such task allowing users to upload free parking lots and then showing them to the drivers using the app.

If a driver decides to occupy a parking lot, he must pay a tinny amount to the userRest that uploaded such parking lot.

When the driver leaves the parking lot, he has the opportunity to recover his payment by uploading the now free parking lot.

# User:

###  Create:

Post to: https://ipark-api.herokuapp.com/userRest

example body:

```
{
 "name"     : "user_name"           (string)
 "password" : "pass"                (string)
 "email"    : "email@domain.com"    (string)
}  
```

### List:

Get to: https://ipark-api.herokuapp.com/userRest

### Get:

**To see userRest**

Get to: https://ipark-api.herokuapp.com/userRest/${id}

**To see userRest's parking lots**

Get to: https://ipark-api.herokuapp.com/userRest/${id}/parkingLots

**To see userRest's parking lots reservations**

Get to: https://ipark-api.herokuapp.com/userRest/${id}/reservations

### Delete

Delete to: https://ipark-api.herokuapp.com/userRest/${id}

### Update

Put to: https://ipark-api.herokuapp.com/userRest/${id}

example body:

```
{
 "name"     : "new_user_name"           (string)
 "password" : "new_pass"                (string)
 "email"    : "new_email@domain.com"    (string)
}  
```

# ParkingLot:

###  Create:

Post to: https://ipark-api.herokuapp.com/parkingLotRest

example body:

```
{
"longitude"   : "longitude"       (string)
"latitude"    : "longitude"       (string)
"space"       : "space"           (integer or string in millimeters)
"description" : "description"     (string)
"picture"     : "picture"         (string)
"creator"     : "user_id"         (existing userRest id)
"parkingMeter": "true/false"      (boolean)
}
```

### List:

Get to: https://ipark-api.herokuapp.com/parkingLotRest

Optional Parameters

| Parameter  | Value    | Description              |
| :---------- |:--------| :------------------------|
| free       | true     | free parking lots        |


### Get:

Get to: https://ipark-api.herokuapp.com/parkingLotRest/${id}

### Delete

Delete to: https://ipark-api.herokuapp.com/parkingLotRest/${id}

### Update

Put to: https://ipark-api.herokuapp.com/parkingLotRest/${id}

example change creator:

```
{
"creator" : "new_user_id"         (existing userRest id)
}
```

example change location:

```
{
"location" : {
    latitude : "new_latitude"   (string)
    longitude: "new_longitude"  (string)     
}
```

You can make multiple changes at once

**re-use parking lot**

Put to set occupant to null and owner to driver

### Reservations

###  Create:

Post to: https://ipark-api.herokuapp.com/reservationRest

example body:

```
{
"occupant"  : "user_id",          (existing_user_id)
"parkingLotRest": "parling_lot_id",   (existing_parking_lot_id)
"minutes"   : "minutes"           (user_estimation)
}
```

###  List:

Get to: https://ipark-api.herokuapp.com/reservationRest

###  GET:

Get to: https://ipark-api.herokuapp.com/reservationRest/${id}

### Update 

Post to https://ipark-api.herokuapp.com/reservationRest/${id}

example body:

```
{
"minutes"   : "new_minutes"           (user_estimation)
}
```

### Delete 

Delete to https://ipark-api.herokuapp.com/reservationRest/${id}

# Login:

### login

Post to: https://ipark-api.herokuapp.com/login

example body:
```
{
"name"   : "user_name"       (string)
"pass"   : "user_pass"      (string)
}
```

response: 200 if validation passes, 404 otherwise

### logout

Post to: https://ipark-api.herokuapp.com/logout (ignores body)
