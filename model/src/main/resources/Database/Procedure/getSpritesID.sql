DELIMITER |
CREATE PROCEDURE getSpritesID (userIdMap INT,userIdSprite  INT, userX INT, userY INT)
BEGIN
	SELECT *
	FROM sprite;
END
|