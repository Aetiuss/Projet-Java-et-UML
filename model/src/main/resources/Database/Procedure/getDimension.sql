DELIMITER |
CREATE PROCEDURE getDimension (userIDMap INT)
BEGIN
	SELECT map.heightMap,map.widthMap
	FROM map
	WHERE map.idMap = userIDMAP;
END
|