# SoccerApi

SoccerApi is Spring Boot rest Api, that implementation of [Football Data API](https://www.football-data.org/ "Football Data API") **v2** .


## Rest Api endpoints

| Description | Endpoint | Football Data API(v2) endpoint
| --- | --- | --- |
| get all competitions | [**/competitions/**] | [competitions](http://api.football-data.org/v2/competitions) |
| get competition by id | [**/competitions/{id}/**] | [competitions/2014](http://api.football-data.org/v2/competitions/2014/) |
| get all teams | [**/teams/**] | [teams](http://api.football-data.org/v2/teams/) |
| get team by id | [/teams/{id}/**] | [teams/66](http://api.football-data.org/v2/teams/66/) |
| get teams of competition by id | [**/competitions/{id}/teams/**] | [competitions/2014/teams](http://api.football-data.org/v2/2014/teams/) |
| get standings of competition by id | [**/competitions/{id}/standings/**] | [competitions/2014/standings](http://api.football-data.org/v2/competitions/2014/standings/) |



**v1** implementation [football-data-api-client](https://github.com/michaelruocco/football-data-api-client.git "Version 1 implementation")

[link football-data]: https://www.football-data.org/