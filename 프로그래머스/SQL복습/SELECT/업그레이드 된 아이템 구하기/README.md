## 문제
- ITEM_A -> ITEM_B일 때, A는 PARENT 아이템
- PARENT가 없는 아이템은 ROOT 아이템
- 'RARE' 아이템들의 다음 업그레이드 아이템의 ITEM_ID, ITEM_NAME, RARITY를 출력

## 풀이
- ITEM_INFO의 RARE 아이템의 ITEM_ID와 ITEM_TREE의 PARENT_ITEM_ID가 일치하는 행 찾고
- 일치하는 행의 ITEM ID로 ITEM_NAME, RARITY 출력
- INNER JOIN 후에 PARENT_ID가 현재 ITEM_INFO의 RARE 등급인 ITEM의 ID중에 해당하면 업그레이드 가능
