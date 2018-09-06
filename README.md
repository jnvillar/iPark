# iPark
[https://ipark-api.herokuapp.com/](https://ipark-api.herokuapp.com/)

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

example change occupant:

```
{
"occupant" : "new_user_id"         (existing user id)
}
```

example change location:

```
{
"location" : {
    latitude : "new_latitude"   (string)
    longitude: "new_longitude"  (string)     
}

Updates the location, should not be used but it works.
```

You can make multiple changes at once

**reserve parking lot**

Put to modify occupant

**re-use parking lot**

Put to set occupant to null and owner to driver

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
