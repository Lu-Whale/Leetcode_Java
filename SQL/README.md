# MySQL Notes:

1. IFNULL()
2. CHAR_LENGTH(content) > 15 
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

## DATE
1. CURRENT_TIME() / CURTIME()
2. CURRENT_TIMESTAMP() / NOW()
3. DATE_ADD(date, INTERVAL expr unit)
4. DATE_SUB(date, INTERVAL expr unit)
5. DATEDIFF(expr1, expr2) 返回两个日期之间的天数差。
6. DATE_FORMAT(date,format) 按照指定格式显示日期。

## Aggregate Function
1. COUNT(expression)
2. SUM(column)
3. AVG(column)
4. MAX(column)
5. MIN(column)
6. GROUP_CONCAT(column ORDER BY column SEPARATOR 'separator')
7. STD(column) / STDDEV(column)
8. VARIANCE(column) / VAR_POP(column) / VAR_SAMP(column)

## Window Function
#### Syntax: OVER ( [PARTITION BY col1, col2, ...] [ORDER BY col1, col2, ...] [frame_clause] )
  - PARTITION BY: Optional, specifies data partitions within the window function. 
  - ORDER BY: Optional, orders the rows within each partition. 
  - frame_clause: Optional, defines the size and range of the window.

#### Aggregate Window Functions:
1. SUM() OVER(...): 计算分区内所有行的总和。 
2. AVG() OVER(...): 计算分区内所有行的平均值。 
3. COUNT() OVER(...): 计算分区内的行数。 
4. MAX() OVER(...): 计算分区内所有行的最大值。 
5. MIN() OVER(...): 计算分区内所有行的最小值。

#### Ranking Window Functions:
1. ROW_NUMBER() OVER(...): 为分区内的每行分配一个唯一的序号。 
2. RANK() OVER(...): 根据指定的排序顺序，为分区内的行分配排名，相同值会有相同的排名，并在下一个值上留下间隔。 
3. DENSE_RANK() OVER(...): 类似于 RANK()，但排名之间没有间隔。 
4. NTILE(n) OVER(...): 将分区内的行分成 n 个相等的组，并为每一组分配一个组号。

#### Analytic Window Functions:
1. LEAD(column, n, default) OVER(...): 返回当前行后面第 n 行的值（向前看）。
2. LAG(column, n, default) OVER(...): 返回当前行前面第 n 行的值（向后看）。 
3. FIRST_VALUE(column) OVER(...): 返回分区内第一行的值。 
4. LAST_VALUE(column) OVER(...): 返回分区内最后一行的值。 
5. CUME_DIST() OVER(...): 计算累积分布。