grammar Genz;

//Spaces and non-graphical characters
WS: ('\n' | '\t' | ' ') -> skip;

COMMENT: ('8=>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*) -> skip;
COMMENT_MULTILINE: ('8==>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'<==8') -> skip;

//KEYWORDS:
TIS: 'tis';
BE: 'be';
OF: 'of';
WITH: 'with';
EXTRA: 'extra';
BRO: 'br'('o')*;
GIV: 'giv';
FAX: 'fax';
CAP: 'cap';
IS: 'is';
OR: 'or';
MEH: 'meh';
BOOTYCALL: 'bootyCall';
FOR: 'for';
BY: 'by';
DO: 'do';
ME: 'me';
NOW: 'now';
FROM: 'from';
TO: 'to';

//IO:
GIMME: 'gimme';
GIVBACK: 'givBack';

//TYPES
STRING: 'string';
INT: 'integer';
FLOAT: 'float';
DOUBLE: 'double';
CHARACTER: 'character';

//VARIABLE NAME
ID: ([a-zA-Z_][a-zA-Z0-9_]*);

//VALUES:
STRING_TYPE: ('"'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*'"');
INT_TYPE: [0]|[1-9]+[0-9]*|'-'[1-9]+[0-9]*;
FLOAT_TYPE: [0]|[1-9]+[0-9]*'.'[0-9]+|'-'[1-9]+[0-9]*'.'[0-9]+;
CHAR_TYPE: '\''([a-zA-Z0-9_ ])'\'';

//Brackets
BRACKET_OPEN: '(';
BRACKET_CLOSE: ')';
CURLY_OPEN: '{';
CURLY_CLOSED: '}';

//SYMBOLS
COMMA: ',';

//OPERATORS
PLUS: '+';
MINUS: '-';
MULTIPLICATION: '*';
DIVISION: '/';
EQUAL: '=';
NOTEQUAL: '<>';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';

//MAIN
GENZ: 'genz';