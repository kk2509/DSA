# Write your MySQL query statement below
# Write your MySQL query statement below

select content_id, content_text as original_text,
    (select group_concat(
        case 
            when regexp_like(left(word, 1), '[:punct:]') then word
            # 2 the main task completed ⬇
            else concat(upper(left(word, 1)), lower(substring(word, 2))) 
        end separator ''
        ) # 3 words concatenated
    from json_table(
        concat('["', regexp_replace(content_text, '([- ])', '$1","'), '"]'),
        "$[*]" columns(word varchar(255) path "$")) as words
    ) as converted_text # 1 text splited
from user_content;
