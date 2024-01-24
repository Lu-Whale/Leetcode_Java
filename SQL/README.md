# MySQL Notes:

1. IFNULL()
2. AVG()
3. 当使用 UNION 来合并两个带有 ORDER BY 或 LIMIT 子句的查询时，需要为每个查询加上括号。(1341)
    - 这是因为 ORDER BY 和 LIMIT 子句适用于整个合并后的结果集，除非它们被包含在子查询中。在您的查询中，每个部分都有自己的 ORDER BY 和 LIMIT 子句，这意味着这些子句只应该影响它们各自的查询结果，而不是整个合并后的结果集。
4. LAG(column_name, offset, default_value) OVER ([PARTITION BY partition_column] ORDER BY order_column)
   - column_name: 需要访问其之前行的列。
   - offset: 相对于当前行的偏移量，默认为 1。
   - default_value: 如果偏移超出了结果集的范围，将返回此值。
   - PARTITION BY partition_column: 可选，用于分区数据。
   - ORDER BY order_column: 定义数据的排序方式。
5. LEAD(column_name, offset, default_value) OVER ([PARTITION BY partition_column] ORDER BY order_column)
   - column_name: 需要访问其后续行的列。 
   - offset: 相对于当前行的偏移量，默认为 1。 
   - default_value: 如果偏移超出了结果集的范围，将返回此值。 
   - PARTITION BY partition_column: 可选，用于分区数据。 
   - ORDER BY order_column: 定义数据的排序方式。
6. SELECT GROUP_CONCAT(column_name) FROM table_name GROUP BY some_column;
7. Regular expression:
   - ^：表示一个字符串或行的开头
   - [a-z]：表示一个字符范围，匹配从 a 到 z 的任何字符。
   - [0-9]：表示一个字符范围，匹配从 0 到 9 的任何字符。
   - [a-zA-Z]：这个变量匹配从 a 到 z 或 A 到 Z 的任何字符。请注意，你可以在方括号内指定的字符范围的数量没有限制，您可以添加想要匹配的其他字符或范围。
   - [^a-z]：这个变量匹配不在 a 到 z 范围内的任何字符。请注意，字符 ^ 用来否定字符范围，它在方括号内的含义与它的方括号外表示开始的含义不同。
   - [a-z]*：表示一个字符范围，匹配从 a 到 z 的任何字符 0 次或多次。
   - [a-z]+：表示一个字符范围，匹配从 a 到 z 的任何字符 1 次或多次。 
   - .：匹配任意一个字符。 
   - \.：表示句点字符。请注意，反斜杠用于转义句点字符，因为句点字符在正则表达式中具有特殊含义。还要注意，在许多语言中，你需要转义反斜杠本身，因此需要使用\\.。 
   - $：表示一个字符串或行的结尾。
8. ROW_NUMBER(): This function assigns a unique number to each row starting from 1 for the first row in each partition. The numbering is reset for each partition. It does not care about duplicates, meaning each row, even if identical, will receive a consecutive number.
   - ROW_NUMBER() OVER (ORDER BY column_name)
9. RANK(): The RANK() function provides a unique rank number to each row within a partition, with gaps in the ranking sequence when there are ties. 
   - RANK() OVER (ORDER BY column_name)
10. DENSE_RANK(): Similar to RANK(), DENSE_RANK() provides a rank number to each row within a partition, but without gaps in the rank values. 
   - DENSE_RANK() OVER (ORDER BY column_name)