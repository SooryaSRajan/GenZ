grammar Genz;

//variable declaration
codeEntry: genz;
genz: globalStatementsRecursive GENZ CURLY_OPEN statementRecursive CURLY_CLOSED globalStatementsRecursive;

//internal statememts
statementRecursive: statement statementRecursive | ;
statement: variableDeclaration | variableAssignment | loop | isThisBlock | outputStmt | inputStmt | methodCall; //TODO: Add acceptable blocks like loops and conditionals

//global statements, can only be functions or variable declaration
globalStatementsRecursive: globalStatements globalStatementsRecursive | ;
globalStatements: variableDeclaration | methodBody;

//values with array creation - only during initialization
values: valuesWithoutArray | arrayValues; //actual values
valuesWithoutArray: STRING_TYPE | INT_TYPE | FLOAT_TYPE | CHAR_TYPE | FAX | CAP;
arrayValues: CURLY_OPEN arrayValuesRecursive CURLY_CLOSED;
arrayValuesRecursive: valuesWithoutArray COMMA arrayValuesRecursive | valuesWithoutArray;

//variable declaration
variableDeclaration: TIS variableDeclarationSelection OF typesWithArray forever;
variableDeclarationSelection: ID initializationOfVariable;
initializationOfVariable: BE values | ;


//TODO: Modify variable declaration for arrays such that either new array or pre-initialized array can be used, not both in a single line

//forever - final
forever: FOREVER | ; //final declaration

//array declaration
typesWithArray: types arrayChoice;
arrayChoice: HIGHKEY arraySize | ;
arraySize: integerIDChoice | ;

//types for variable
types: STRING | INT | FLOAT | DOUBLE | CHARACTER | BOOLEAN; //type keywords

//array indexing:
arrayIndexing: ID GIV integerIDChoice;

//Choice for array indexing / creation
integerIDChoice: INT_TYPE | ID;

//Variable assignment
variableAssignment: ID BE variableAssignmentInner; //assigning to a variable
variableAssignmentInner: expr | conditionalStatement;

//parameter list for methods
parameterList: parameter parameterListChoice | ;
parameterListChoice: COMMA parameter parameterListChoice  | ;
parameter: ID OF typesWithArray;

//method body declaration
methodBody: BOOTYCALL FOR typesWithVoid BY ID BRACKET_OPEN parameterList BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;
typesWithVoid: typesWithArray | SUS; //type keywords with void

//loop:
loop: DO ME FROM expr TO expr loopVairable CURLY_OPEN statementRecursive CURLY_CLOSED;
loopVairable: TIS BE ID | ;

//output statement:
outputStmt: GIVBACK expr;
inputStmt: GIMME ID;

//eppressions
expr : term expressionInner;
expressionInner: add term expressionInner | sub term expressionInner | ;
term : factor termMultDivFactor;
termMultDivFactor: mul factor termMultDivFactor | div factor termMultDivFactor | ;
factor : valuesWithoutArray
    | lp expr rp
    | ID
    | arrayIndexing
    | methodCall;

//conditonal blocks:
isThisBlock: IS TIS BRACKET_OPEN conditionalStatement BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED orIsThisMehBlock;
orIsThisMehBlock: orIsThisBlock orIsThisMehBlock | mehBlock | ;
orIsThisBlock: OR IS TIS BRACKET_OPEN conditionalStatement BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;
mehBlock: MEH CURLY_OPEN statementRecursive CURLY_CLOSED;

//method CALL
methodCall: ID BRACKET_OPEN parameterCallList BRACKET_CLOSE;
parameterCallList: expr parameterCallListChoice | ;
parameterCallListChoice: COMMA expr parameterCallListChoice | ;

//conditions for loops and if
conditionalStatement : conditionStatement conditionBooleans
   | NOT_CONDT conditionalStatement;
conditionBooleans: AND_CONDT conditionalStatement | OR_CONDT conditionalStatement | ;

//condition statement can either be odd or expressiosn with conditions
conditionStatement : expr conditionalChoice;
conditionalChoice:  conditionalOperations expr | ;

//operations for contitions
conditionalOperations : LT
    | LTE
    | EQUAL
    | GTE
    | GT
    | NOTEQUAL;

lp: BRACKET_OPEN
    ;

rp: BRACKET_CLOSE
    ;

add: PLUS
    ;

sub: MINUS
    ;

mul: MULTIPLICATION
    ;

div: DIVISION
    ;

//Spaces and non-graphical characters
WS: ('\n' | '\t' | ' ') -> skip;

//MAIN
GENZ: 'genz';

//KEYWORDS:
TIS: 'tis';
BE: 'be';
OF: 'of';
WITH: 'with';
HIGHKEY: 'highkey';
BRO: 'br'('o')*;
GIV: 'giv';
IS: 'is';
OR: 'or';
MEH: 'meh';
BOOTYCALL: 'bootyCall';
FOR: 'for';
BY: 'by';
DO: 'do';
ME: 'me';
NOW: 'now';
LATER: 'later';
FROM: 'from';
TO: 'to';
FOREVER: 'forever'; //final
OR_CONDT: '||';
AND_CONDT: '&&';
NOT_CONDT: '!';

//IO:
GIMME: 'gimme';
GIVBACK: 'givBack';

//TYPES
STRING: 'string';
INT: 'integer';
FLOAT: 'float';
DOUBLE: 'double';
CHARACTER: 'character';
BOOLEAN: 'boolean';
SUS: 'sus'; //void

//VALUES:
FAX: 'fax';
CAP: 'cap';
STRING_TYPE: ('"'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*'"');
INT_TYPE: [0]|[1-9]+[0-9]*|'-'[1-9]+[0-9]*;
FLOAT_TYPE: [0]|[1-9]+[0-9]*'.'[0-9]+|'-'[1-9]+[0-9]*'.'[0-9]+;
CHAR_TYPE: '\''([a-zA-Z0-9_ ])'\'';

//VARIABLE NAME
ID: ([a-zA-Z_][a-zA-Z0-9_]*);

//Bracketchars
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

//Comments
COMMENT: ('8=>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*) -> skip;
COMMENT_MULTILINE: ('8==>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'<==8') -> skip;

