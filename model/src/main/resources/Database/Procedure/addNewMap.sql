DELIMITER |
CREATE PROCEDURE addNewMap (userIdMap INT, userNameMap VARCHAR(50), userWidthMap INT, userHeightMap INT)
BEGIN
	INSERT INTO map (idMap, nameMap, widthMap, heightMap)
	VALUES (userIdMap, userNameMap, userWidthMap, userHeightMap);
END
|