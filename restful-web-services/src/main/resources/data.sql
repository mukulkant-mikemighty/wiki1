ALTER TABLE searches ALTER COLUMN snippet SET DATA TYPE NVARCHAR(MAX);


insert into Searches (title, page_Id, size, word_Count,snippet,timestamp)
values ('SpaceX', 832774, 138346, 13655, 
'<span class=\"searchmatch\">Space</span> Exploration Technologies Corp., trading as <span class=\"searchmatch\">Space</span>X, is a private  <span class=\"searchmatch\">space</span> ',
'2020-05-14T13:17:17Z');