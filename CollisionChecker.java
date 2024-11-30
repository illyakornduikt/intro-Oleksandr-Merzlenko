package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        this.gp.getClass();
        int entityLeftCol = entityLeftWorldX / 48;
        this.gp.getClass();
        int entityRightCol = entityRightWorldX / 48;
        this.gp.getClass();
        int entityTopRow = entityTopWorldY / 48;
        this.gp.getClass();
        int entityBottomRow = entityBottomWorldY / 48;
        int tileNum1;
        int tileNum2;
        int var10000;
        switch (entity.direction) {
            case "up":
                var10000 = entityTopWorldY - entity.speed;
                this.gp.getClass();
                entityTopRow = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                var10000 = entityBottomWorldY + entity.speed;
                this.gp.getClass();
                entityBottomRow = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                var10000 = entityLeftWorldX - entity.speed;
                this.gp.getClass();
                entityLeftCol = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                var10000 = entityRightWorldX + entity.speed;
                this.gp.getClass();
                entityRightCol = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
        }

    }
    public int checkObject(Entity entity, boolean player) {
    	
    	int index = 999;
    	
    	for(int i = 0; i < gp.obj.length; i++) {
    		
    		if(gp.obj[i] != null) {
    			
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			
    			gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
    			gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
    			
    			switch(entity.direction) {
    			case "up": entity.solidArea.y -= entity.speed;
    			if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    				if(gp.obj[i].collision == true) {
    					entity.collisionOn = true;
    				}
    				if(player == true) {
    					index = i;
    				}
    			} break;
    			case "down": entity.solidArea.y += entity.speed;
    			if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    				if(gp.obj[i].collision == true) {
    					entity.collisionOn = true;
    				}
    				if(player == true) {
    					index = i;
    				}
    			} break;
    			case "left": entity.solidArea.x -= entity.speed;
    			if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    				if(gp.obj[i].collision == true) {
    					entity.collisionOn = true;
    				}
    				if(player == true) {
    					index = i;
    				}
    			} break;
    			case "right": entity.solidArea.x += entity.speed; 
    			if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
    				if(gp.obj[i].collision == true) {
    					entity.collisionOn = true;
    				}
    				if(player == true) {
    					index = i;
    				}
    			} break;
    			}
    			entity.solidArea.x = entity.solidAreaDefaultX;
        		entity.solidArea.y = entity.solidAreaDefaultY;
        		gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
        		gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
    		}
    		
    	}
    	
    	return index;
    }
}