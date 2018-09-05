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

Get to: https://ipark-api.herokuapp.com/user/${id}

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
"owner"       : "user_id"         (existing user id)
}
```

### List:

Get to: https://ipark-api.herokuapp.com/parkingLot

### Get:

Get to: https://ipark-api.herokuapp.com/parkingLot/${id}

### Delete

Delete to: https://ipark-api.herokuapp.com/parkingLot/${id}

### Update

Put to: https://ipark-api.herokuapp.com/parkingLot/${id}

example body:

```
{
"longitude"   : "new_longitude"       (string)
"latitude"    : "new_longitude"       (string)
"space"       : "new_space"           (integer or string in millimeters)
"description" : "new_description"     (string)
"picture"     : "new_picture"         (string)
"owner"       : "new_user_id"         (existing user id)
}
```
