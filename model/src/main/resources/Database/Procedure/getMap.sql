DELIMITER |
CREATE PROCEDURE getMap (userIDMap INT)
BEGIN
	SELECT compose.x,compose.y, sprite.charSprite
	FROM compose
	LEFT JOIN sprite ON compose.idSprite = sprite.idSprite
	WHERE compose.idMap = userIDMAP;
END
|