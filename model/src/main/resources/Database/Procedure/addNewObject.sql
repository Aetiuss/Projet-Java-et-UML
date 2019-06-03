DELIMITER |
CREATE PROCEDURE addNewObject (userIdMap INT,userIdSprite  INT, userX INT, userY INT)
BEGIN
	INSERT INTO compose (compose.idSprite, compose.idMap , compose.x, compose.y)
	VALUES (userIdSprite, userIdMap, userX, userY);
END
|