# Showcase REST API - Kotlin

## Task description

1. receives HTTP POST requests only on a "/track" route
    - gets data in JSON format passed in the request body
    - saves the JSON data into a local file (append)
    - 🚧 **Coming Soon** 🚧 if the data contains a "count" parameter, the application increments the value of the "count" key by the value of the 'count' parameter in a Redis database
2. 🚧 **Coming Soon** 🚧 receives HTTP GET requests only on a "/count" route
    - 🚧 **Coming Soon** 🚧 returns the value of the "count" key from the Redis database

### Features

apart from the above-mentioned requirements

- ✅ Spring Boot framework
- ✅ Extensive unit tests
- 🚧 **Coming Soon** 🚧 Coding standards
- ✅ Error handling
- 🚧 **Coming Soon** 🚧 Error logging to file
- ✅ JSON input validation (jakarta)
- 🚧 **Coming Soon** 🚧 Docker for convenient team development
- 🚧 **Coming Soon** 🚧 Easy to change count storage implementation
- ✅ Easy to change Request data storage implementation

## Testing app

curl -X POST -H "Content-Type: application/json" -d '{"uuid": 1, "count": 2, "name": "whatever"}' http://localhost:8080/track