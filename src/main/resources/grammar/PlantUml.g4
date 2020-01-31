grammar PlantUml;

/* Lexer Rules */
START_UML: '@startuml';
END_UML: '@enduml';

// PlantUML besitzt gleiches Zeichen für Start- und Endzustand
START_END_STATE: '[*]';

COLON: ':';
COMMA: ',';

ASSIGN_OP: '=';

OP_EQUAL: '==';
// Less Then
OP_LT: '<';
// Lesser Or Equal
OP_LTE: '<=';
// Greater Then
OP_GT: '>';
// Greater Or OP_EQUAL
OP_GTE: '>=';
PLUS: '+';
MINUS: '-';
DIVIDE: '/';
MULT: '*';

BRACKET_OPEN: '[';
BRACKET_CLOSE: ']';
CLOSURE_OPEN: '(';
CLOSURE_CLOSE: ')';
CLOSURE: '()';

AND: '&';
OR: '|';

STRING: 'string';
INTEGER: 'int';
UINTEGER: 'uint';
ADDRESS: 'address';
BOOLEAN: 'bool';
BYTE_ARRAY: 'bytes';

TRUE: 'true';
FALSE: 'false';

// Währungseinheiten
ETHER: 'ether';
WEI: 'wei';

// Zeiteinheiten
DAYS: 'days';

SOL_GLOBAL_SENDER: 'sender';
SOL_GLOBAL_VALUE: 'msg.value';
SOL_GLOBAL_DATE: 'now';
SOL_GLOBAL_DATE2: 'block.timestamp';

// UML Pfeile (Transitionen)
ARROW: '->';
LONG_ARROW: '-->';
LONG_ARROW_UP: '-u->';
LONG_ARROW_DOWN: '-d->';
LONG_ARROW_LEFT: '-l->';
LONG_ARROW_RIGHT: '-r->';

ACTIVITY: 'entry/' | 'exit/';

RETURN: 'return';

SKINPARAM: 'skinparam';

NUMBER: [0-9]+;
// Farben in Hex Notation, ANTLR unterstützt keine Mengenangaben z. B. {3}
HEX_COLOR: '#' [0-9A-F]+;
// Bezeichner von Klassen, Attributen
IDENTIFIER: [a-zA-Z]+;

// ?. Sorgt dafür, dass der Lexer Leerzeichen etc. als Tokens ignoriert
WS: [ \r\t\n]+ -> skip;

// GENERIC VALUE (Muss ganz unten in den Lexer Rules stehen, sonst werden alle Tokens dieser Lexer
// Regel zugewiesen
VALUE: [0-9a-zA-Z#+-/*"]+;

/* Parser Rules */

// Parameter, um Optik des Diagramms zu ändern. Mit eingebaut, damit Parser u. Lexer keine Fehler
// werfen
skinParamCmds:
	SKINPARAM ('Monochrome' | 'Shadowing') (TRUE | FALSE);

// Aufbau einer plant uml Datei, in der Zustandsdiagramme erstellt werden
plantUml:
	START_UML IDENTIFIER skinParamCmds* (stateDef | transition)* END_UML;

// Name eines Zustands
state: START_END_STATE | IDENTIFIER;

// Anweisungen innerhalb eines Statements
stateDef: state COLON ACTIVITY statement;

statement:
	p = param ASSIGN_OP r = expression	# FieldDeclrAndExprAssignment
	| p = param ASSIGN_OP r = VALUE		# FieldDeclrAndAssignment
	| expression						# ExpressionStatement;

// Zustandsübergang. Mit extra "pay" Funktion
transition:
	l = state arrow r = state COLON i = IDENTIFIER									# Trans
	| l = state arrow r = state COLON i = IDENTIFIER c = condition					# TransCond
	| l = state arrow r = state COLON i = 'pay' v = NUMBER u = unit					# TransPay
	| l = state arrow r = state COLON i = 'pay' v = NUMBER u = unit c = condition	# TransPayCond
	| l = state arrow r = state COLON i = 'pay*'									# TransPayStar
	| l = state arrow r = state COLON i = 'pay*' c = condition						# TransPayStarCond
	| l = state arrow r = state														# EmptyTrans;

// Bedingungen an Zustandsübergängen
condition: BRACKET_OPEN expression BRACKET_CLOSE;

compOperator: OP_EQUAL | OP_LT | OP_LTE | OP_GT | OP_GTE;

mathOperator: PLUS | MINUS | DIVIDE | MULT;

type:
	STRING
	| INTEGER
	| UINTEGER
	| ADDRESS
	| BOOLEAN
	| BYTE_ARRAY
	| type COMMA type;

unit: ETHER | WEI;

timeUnit: DAYS;

// Element auf der linken Seite einer Zuweisung
variable:
	SOL_GLOBAL_VALUE
	| SOL_GLOBAL_DATE
	| SOL_GLOBAL_DATE2
	| IDENTIFIER;

constant: NUMBER | NUMBER unit | NUMBER timeUnit;

// Ausdruck wie 1 + 1 etc. Zusätzlich auch eine 'sent from x' Expression. 'sent from x' ist als
// Expression gewählt, da es äquivalent zu 'msg.sender == x' ist (CompOperation) Zu dem ist auch
// eine Verkettung der Ausdrücke enthalten (UND, ODER). Normalerweise müsste man in Conditional-,
// Assignment-, Additive-Expressions usw. unterscheiden aber das wird im Rahmen der Arbeit vorerst
// nicht behandelt
expression:
	l = expression op = AND r = expression				# CondExpr
	| l = expression op = OR r = expression				# CondORExpr
	| lv = expression op = mathOperator rv = expression	# MathOperation
	| lv = expression op = compOperator rv = expression	# CompOperation
	| l = variable ASSIGN_OP r = expression				# Assignment
	| 'sent from' variable								# SentFromExpr
	| constant											# JustAConstant
	| variable											# JustAVariable
	| method											# MethodCall;

// Parameter für Methoden. Identisch mit zweiter Alternative der attr Regel. Aufgrund der
// Formatierung nachher im Compiler, aber nicht ander lösbar
param: id = IDENTIFIER COLON t = type;

// Methoden. Verschiedene Regeln für verschiedene Signaturen +
method:
	id = IDENTIFIER CLOSURE														# NoParamMeth
	| id = IDENTIFIER CLOSURE_OPEN expression (COMMA expression)* CLOSURE_CLOSE	# ParamMeth;

arrow:
	ARROW
	| LONG_ARROW
	| LONG_ARROW_UP
	| LONG_ARROW_DOWN
	| LONG_ARROW_LEFT
	| LONG_ARROW_RIGHT;
