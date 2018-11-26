# JBossOutreachRepositories
google codein task submission, jboss organization app to load all repos information from jboss organization and contributor information using network calling okhttp and json parsing of result script

Youtube link to the screen recording
https://www.youtube.com/watch?v=YZ6zB9dyMU0

the application reads all the repositories in the jboss github page includuing the name, language type, fork count, stargaze count, 
and last update time. it displays in a recyclerview. when each repo is clicked, the information about all the contributors is displayed in a recyclerview. the contributor profimage, name, contributions, and url is displayed. 

libraries used:
okhttp library for network calling
glide to load images
