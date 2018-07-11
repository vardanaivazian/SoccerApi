# SoccerApi

[![Build Status](https://travis-ci.org/vardanaivazian/SoccerApi.svg?branch=master)](https://travis-ci.org/vardanaivazian/SoccerApi)

SoccerApi is Spring Boot rest Api, that implementation of [Football Data API](https://www.football-data.org/ "Football Data API") (**v2**) .


## Rest Api endpoints

| Description | Endpoint | Football Data API(v2) endpoint |
| --- | --- | --- |
| get all competitions | [**/competitions/**] | [competitions](http://api.football-data.org/v2/competitions) |
| get competition by id | [**/competitions/{id}/**] | [competitions/2014](http://api.football-data.org/v2/competitions/2014/) |
| get all teams | [**/teams/**] | [teams](http://api.football-data.org/v2/teams/) |
| get team by id | [**/teams/{id}/**] | [teams/66](http://api.football-data.org/v2/teams/66/) |
| get teams of competition by id | [**/competitions/{id}/teams/**] | [competitions/2014/teams](http://api.football-data.org/v2/2014/teams/) |
| get standings of competition by id | [**/competitions/{id}/standings/**] | [competitions/2014/standings](http://api.football-data.org/v2/competitions/2014/standings/) |


## Usage

Change Token in `TokenProviderServiceImpl -> TOKEN = "YOUR_TOKEN"`
Token can be obtained by registering on the site [Football Data API](https://www.football-data.org/ "Football Data API")


## Running the tests

*no tests


## Built With

- [Maven](https://maven.apache.org/) - Dependency Management


## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/vardanaivazian/SoccerApi/blob/master/LICENSE) file for details


## Versioning

Here used [Football Data API](https://www.football-data.org/ "Football Data API") (**Version 2**)
for the (**Version 1**) implementation see [here](https://github.com/michaelruocco/football-data-api-client.git "Version 1 implementation") 

[link football-data]: https://www.football-data.org/