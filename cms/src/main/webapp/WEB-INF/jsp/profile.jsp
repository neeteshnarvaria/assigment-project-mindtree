<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<img src="${userProfile.profileImageUrl}"/>

Screen name: ${userProfile.screenName}

Name: ${userProfile.name}

Description: ${userProfile.description}

Location: ${userProfile.location}

Followers: ${userProfile.followersCount}

</body>
</html>