grammar Genz;

//variable declaration
codeEntry: globalStatementsRecursive genz globalStatementsRecursive;
genz:  GENZ CURLY_OPEN statementRecursive CURLY_CLOSED;

//Internal Statememts
statementRecursive: statement statementRecursive | ;
statement: variableDeclaration | variableAssignment | arrayAssignment | forLoop | whileLoop | ifElseIfElseBlock | outputStmt | inputStmt | statementMethodCall | returnStatement | yeetStatement;
yeetStatement: YEET;

//Global Statements, can only be functions or variable declaration
globalStatementsRecursive: globalStatements globalStatementsRecursive | ;
globalStatements: variableDeclaration | methodBody;

//Values with Array Creation - only during initialization
values: valuesWithoutArray | arrayValues; //actual values
valuesWithoutArray: STRING_TYPE | INT_TYPE | FLOAT_TYPE | CHAR_TYPE | FAX | CAP;
arrayValues: CURLY_OPEN arrayValuesRecursive CURLY_CLOSED;
arrayValuesRecursive: valuesWithoutArray COMMA arrayValuesRecursive | valuesWithoutArray;

//Variable Declaration
variableDeclaration: TIS variableDeclarationSelection OF typesWithArray forever;
variableDeclarationSelection: ID initializationOfVariable;
initializationOfVariable: BE values | ;

//Forever - final
forever: FOREVER | ; //final declaration

//Array Declaration
typesWithArray: types arrayChoice;
arrayChoice: ARRAY arraySize | ;
arraySize: integerIDChoice | ;

//Types for Variable
types: STRING | INT | FLOAT | DOUBLE | CHARACTER | BOOLEAN; //type keywords

//Array Indexing:
arrayIndexing: ID GIV integerIDChoice;

//Array Size:
getArraySize: ARRAY_SIZE OF ID;

//Choice for array indexing / creation
integerIDChoice: INT_TYPE | ID;

//Variable Assignment
variableAssignment: ID BE variableAssignmentInner; //assigning to a variable
variableAssignmentInner: expressionGrammar | conditionalStatementEntry;

//Array Assignment
arrayAssignment: ID GIV integerIDChoice BE variableAssignmentInner; //assigning to an array

//Parameter List for Methods
parameterList: parameter parameterListChoice | ;
parameterListChoice: COMMA parameter parameterListChoice  | ;
parameter: ID OF typesWithArray;

//Method Body Declaration
methodBody: FUNCTIONCALL FOR typesWithVoid IN ID BRACKET_OPEN parameterList BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;
typesWithVoid: typesWithArray | NOOB; //type keywords with void

//Loop:
forLoop: DO ME FROM expressionGrammar TO expressionGrammar forLoopDirection loopVairable CURLY_OPEN statementRecursive CURLY_CLOSED;
forLoopDirection: CHEUGY | ;
loopVairable: TIS BE ID ;

whileLoop: DO ME FOR conditionalStatement CURLY_OPEN statementRecursive CURLY_CLOSED;

//IO Statements:
outputStmt: PRINT outputChoices;
outputChoices: conditionalStatement | expressionGrammar;
inputStmt: INPUT ID inputForArray OF types;
inputForArray: GIV integerIDChoice | ;

//Expressions
expressionGrammar: expr;
expr : term expressionInner;
expressionInner: add term expressionInner | sub term expressionInner | mod term expressionInner | ;
term : factor termMultDivFactor;
termMultDivFactor: mul factor termMultDivFactor | div factor termMultDivFactor | ;
factor : valuesWithoutArray
    | lp expr rp
    | getExpressionID
    | arrayIndexing
    | getArraySize
    | methodCall;

getExpressionID: ID;

//Conditonal Blocks:
ifElseIfElseBlock: isThisBlock elseIfBlock;
elseIfBlock: orIsThisBlock elseIfBlock | mehBlock | ;
isThisBlock: IS TIS BRACKET_OPEN conditionalStatementEntry BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;
orIsThisBlock: OR IS TIS BRACKET_OPEN conditionalStatementEntry BRACKET_CLOSE CURLY_OPEN statementRecursive CURLY_CLOSED;
mehBlock: MEH CURLY_OPEN statementRecursive CURLY_CLOSED;

//Method CALL
statementMethodCall: methodCall;
methodCall: ID BRACKET_OPEN parameterCallList BRACKET_CLOSE;
parameterCallList: expressionGrammar parameterCallListChoice | ;
parameterCallListChoice: commaBlock expressionGrammar parameterCallListChoice | ;
commaBlock: COMMA;

//Method Return:
returnStatement: RETURN returnValue;
returnValue: expressionGrammar | conditionalStatementEntry | ;

//Conditional Statements:
conditionalStatementEntry: conditionalStatement;
conditionalStatement
 : lp conditionalStatement rp
 | notOperand conditionalStatement
 | conditionalStatement conditionalOperations conditionalStatement
 | conditionalStatement binaryOperands conditionalStatement
 | expressionGrammar
 ;

binaryOperands: AND_CONDT | OR_CONDT;
notOperand: NOT_CONDT;

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

mod: MOD
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
ARRAY: 'chonky';
BRO: 'br'('o')*;
GIV: 'giv';
IS: 'is';
OR: 'or';
MEH: 'meh';
FUNCTIONCALL: 'finesse';
FOR: 'for';
IN: 'in';
DO: 'do';
ME: 'me';
NOW: 'now';
LATER: 'later';
FROM: 'from';
TO: 'to';
FOREVER: 'forever'; //final
YEET: 'yeet'; //break
CHEUGY: 'cheugy';
ARRAY_SIZE: 'size';

//IO:
INPUT: 'gimme';
PRINT: 'flex';

//return
RETURN: 'clapBack';

//TYPES
STRING: 'string';
INT: 'integer';
FLOAT: 'float';
DOUBLE: 'double';
CHARACTER: 'character';
BOOLEAN: 'boolean';
NOOB: 'noob'; //void

//VALUES:
FAX: 'fax';
CAP: 'cap';
STRING_TYPE: ('"'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*'"');
FLOAT_TYPE: '-'? (DIGITS '.' DIGITS | '.' DIGITS | DIGITS '.') ;
INT_TYPE: [0]|[1-9]+[0-9]*|'-'[1-9]+[0-9]*;
CHAR_TYPE: '\''([a-zA-Z0-9_ ])'\'';

fragment DIGITS : [0-9]+ ;

//BRACKETS
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
MOD: 'mod';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
OR_CONDT: '||';
AND_CONDT: '&&';
NOT_CONDT: '!';

//VARIABLE NAME
ID: ([a-zA-Z_][a-zA-Z0-9_]*);

//COMMENTS
COMMENT: ('8=>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9\n])*) -> skip;
COMMENT_MULTILINE: ('8==>'([a-zA-Z0-9_ ]|~[a-zA-Z0-9])*'<==8') -> skip;

