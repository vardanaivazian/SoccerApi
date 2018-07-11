#SoccerApi

SoccerApi is Spring Boot rest Api, that implementation of www.football-data.org.

Rest Api endpoints

get all competitions	[/competitions/]	competitions
get competition by id	[/competitions/{id}/]	competitions/{id}
get all teams	[/teams/]	teams
get team by id	[/teams/{id}/]	teams/{id}/
get teams of competition by id	[/competitions/{id}/teams/]	competitions/{id}/teams
get all matches of competition by id	[/competitions/{id}/matches/]	competitions/{id}/matches
get standings of competition by id	[/competitions/{id}/standings/]	competitions/{id}/standings



get standings of competition with id = '2021' => http://localhost:8080/competitions/2021/standings


get competitions http://api.football-data.org/v2/competitions

get competition with id = '2021'  =>  http://api.football-data.org/v2/competitions/2021/

get teams of competition with id = '2021'  =>  http://api.football-data.org/v2/competitions/2021/teams/

get standings of competition with id = '2021'  =>  http://api.football-data.org/v2/competitions/2021/standings/

get all matches of competition with id = '2021'  =>  http://api.football-data.org/v2/competitions/2021/matches/

get all teams  =>  http://api.football-data.org/v2/teams/

get teams of competitions with id = '2021'  =>  http://api.football-data.org/v2/competitions/2021/teams

get team with id = '77'  =>  http://api.football-data.org/v2/teams/77/