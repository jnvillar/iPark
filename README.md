# iPark
[https://ipark-api.herokuapp.com/](https://ipark-api.herokuapp.com/)

iPark is a restApi who's objective is to manage free parking lots on the street. iPark accomplishes such task allowing users to upload free parking lots and then showing them to the drivers using the app.

If a driver decides to occupy a parking lot, he must pay a tinny amount to the user that uploaded such parking lot.

When the driver leaves the parking lot, he has the opportunity to recover his payment by uploading the now free parking lot.

# User:

###  Create:

Post to: https://ipark-api.herokuapp.com/user

example body:

```
{
 "name"     : "user_name"           (string)
 "password" : "pass"                (string)
 "email"    : "email@domain.com"    (string)
}  
```

### List:

Get to: https://ipark-api.herokuapp.com/user

### Get:

**To see user**

Get to: https://ipark-api.herokuapp.com/user/${id}

**To see user's parking lots**

Get to: https://ipark-api.herokuapp.com/user/${id}/parkingLots

**To see user's parking lots reservations**

Get to: https://ipark-api.herokuapp.com/user/${id}/reservations

### Delete

Delete to: https://ipark-api.herokuapp.com/user/${id}

### Update

Put to: https://ipark-api.herokuapp.com/user/${id}

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

Post to: https://ipark-api.herokuapp.com/parkingLot

example body:

```
{
"longitude"   : "longitude"       (string)
"latitude"    : "longitude"       (string)
"space"       : "space"           (integer or string in millimeters)
"description" : "description"     (string)
"picture"     : "picture"         (string)
"creator"     : "user_id"         (existing user id)
"parkingMeter": "true/false"      (boolean)
}
```

### List:

Get to: https://ipark-api.herokuapp.com/parkingLot

Optional Parameters

| Parameter  | Value    | Description              |
| :---------- |:--------| :------------------------|
| free       | true     | free parking lots        |


### Get:

Get to: https://ipark-api.herokuapp.com/parkingLot/${id}

### Delete

Delete to: https://ipark-api.herokuapp.com/parkingLot/${id}

### Update

Put to: https://ipark-api.herokuapp.com/parkingLot/${id}

example change creator:

```
{
"creator" : "new_user_id"         (existing user id)
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

Post to: https://ipark-api.herokuapp.com/reservation

example body:

```
{
"occupant"  : "user_id",          (existing_user_id)
"parkingLot": "parling_lot_id",   (existing_parking_lot_id)
"minutes"   : "minutes"           (user_estimation)
}
```

###  List:

Get to: https://ipark-api.herokuapp.com/reservation

###  GET:

Get to: https://ipark-api.herokuapp.com/reservation/${id}

### Update 

Post to https://ipark-api.herokuapp.com/reservation/${id}

example body:

```
{
"minutes"   : "new_minutes"           (user_estimation)
}
```

### Delete 

Delete to https://ipark-api.herokuapp.com/reservation/${id}

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
