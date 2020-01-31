// Generated from /home/andi/fhdo/Lehrveranstaltungen/Bachelorarbeit/Anwenderfreundliche Smart Contracts/meivsm-compiler/src/main/resources/grammar/PlantUml.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlantUmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, START_UML=6, END_UML=7, START_END_STATE=8, 
		COLON=9, COMMA=10, ASSIGN_OP=11, OP_EQUAL=12, OP_LT=13, OP_LTE=14, OP_GT=15, 
		OP_GTE=16, PLUS=17, MINUS=18, DIVIDE=19, MULT=20, BRACKET_OPEN=21, BRACKET_CLOSE=22, 
		CLOSURE_OPEN=23, CLOSURE_CLOSE=24, CLOSURE=25, AND=26, OR=27, STRING=28, 
		INTEGER=29, UINTEGER=30, ADDRESS=31, BOOLEAN=32, BYTE_ARRAY=33, TRUE=34, 
		FALSE=35, ETHER=36, WEI=37, DAYS=38, SOL_GLOBAL_SENDER=39, SOL_GLOBAL_VALUE=40, 
		SOL_GLOBAL_DATE=41, SOL_GLOBAL_DATE2=42, ARROW=43, LONG_ARROW=44, LONG_ARROW_UP=45, 
		LONG_ARROW_DOWN=46, LONG_ARROW_LEFT=47, LONG_ARROW_RIGHT=48, ACTIVITY=49, 
		RETURN=50, SKINPARAM=51, NUMBER=52, HEX_COLOR=53, IDENTIFIER=54, WS=55, 
		VALUE=56;
	public static final int
		RULE_skinParamCmds = 0, RULE_plantUml = 1, RULE_state = 2, RULE_stateDef = 3, 
		RULE_statement = 4, RULE_transition = 5, RULE_condition = 6, RULE_compOperator = 7, 
		RULE_mathOperator = 8, RULE_type = 9, RULE_unit = 10, RULE_timeUnit = 11, 
		RULE_variable = 12, RULE_constant = 13, RULE_expression = 14, RULE_param = 15, 
		RULE_method = 16, RULE_arrow = 17;
	public static final String[] ruleNames = {
		"skinParamCmds", "plantUml", "state", "stateDef", "statement", "transition", 
		"condition", "compOperator", "mathOperator", "type", "unit", "timeUnit", 
		"variable", "constant", "expression", "param", "method", "arrow"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Monochrome'", "'Shadowing'", "'pay'", "'pay*'", "'sent from'", 
		"'@startuml'", "'@enduml'", "'[*]'", "':'", "','", "'='", "'=='", "'<'", 
		"'<='", "'>'", "'>='", "'+'", "'-'", "'/'", "'*'", "'['", "']'", "'('", 
		"')'", "'()'", "'&'", "'|'", "'string'", "'int'", "'uint'", "'address'", 
		"'bool'", "'bytes'", "'true'", "'false'", "'ether'", "'wei'", "'days'", 
		"'sender'", "'msg.value'", "'now'", "'block.timestamp'", "'->'", "'-->'", 
		"'-u->'", "'-d->'", "'-l->'", "'-r->'", null, "'return'", "'skinparam'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "START_UML", "END_UML", "START_END_STATE", 
		"COLON", "COMMA", "ASSIGN_OP", "OP_EQUAL", "OP_LT", "OP_LTE", "OP_GT", 
		"OP_GTE", "PLUS", "MINUS", "DIVIDE", "MULT", "BRACKET_OPEN", "BRACKET_CLOSE", 
		"CLOSURE_OPEN", "CLOSURE_CLOSE", "CLOSURE", "AND", "OR", "STRING", "INTEGER", 
		"UINTEGER", "ADDRESS", "BOOLEAN", "BYTE_ARRAY", "TRUE", "FALSE", "ETHER", 
		"WEI", "DAYS", "SOL_GLOBAL_SENDER", "SOL_GLOBAL_VALUE", "SOL_GLOBAL_DATE", 
		"SOL_GLOBAL_DATE2", "ARROW", "LONG_ARROW", "LONG_ARROW_UP", "LONG_ARROW_DOWN", 
		"LONG_ARROW_LEFT", "LONG_ARROW_RIGHT", "ACTIVITY", "RETURN", "SKINPARAM", 
		"NUMBER", "HEX_COLOR", "IDENTIFIER", "WS", "VALUE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PlantUml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PlantUmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SkinParamCmdsContext extends ParserRuleContext {
		public TerminalNode SKINPARAM() { return getToken(PlantUmlParser.SKINPARAM, 0); }
		public TerminalNode TRUE() { return getToken(PlantUmlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PlantUmlParser.FALSE, 0); }
		public SkinParamCmdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skinParamCmds; }
	}

	public final SkinParamCmdsContext skinParamCmds() throws RecognitionException {
		SkinParamCmdsContext _localctx = new SkinParamCmdsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_skinParamCmds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(SKINPARAM);
			setState(37);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(38);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlantUmlContext extends ParserRuleContext {
		public TerminalNode START_UML() { return getToken(PlantUmlParser.START_UML, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public TerminalNode END_UML() { return getToken(PlantUmlParser.END_UML, 0); }
		public List<SkinParamCmdsContext> skinParamCmds() {
			return getRuleContexts(SkinParamCmdsContext.class);
		}
		public SkinParamCmdsContext skinParamCmds(int i) {
			return getRuleContext(SkinParamCmdsContext.class,i);
		}
		public List<StateDefContext> stateDef() {
			return getRuleContexts(StateDefContext.class);
		}
		public StateDefContext stateDef(int i) {
			return getRuleContext(StateDefContext.class,i);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public PlantUmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plantUml; }
	}

	public final PlantUmlContext plantUml() throws RecognitionException {
		PlantUmlContext _localctx = new PlantUmlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_plantUml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(START_UML);
			setState(41);
			match(IDENTIFIER);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SKINPARAM) {
				{
				{
				setState(42);
				skinParamCmds();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==START_END_STATE || _la==IDENTIFIER) {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(48);
					stateDef();
					}
					break;
				case 2:
					{
					setState(49);
					transition();
					}
					break;
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(END_UML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public TerminalNode START_END_STATE() { return getToken(PlantUmlParser.START_END_STATE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==START_END_STATE || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateDefContext extends ParserRuleContext {
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public TerminalNode ACTIVITY() { return getToken(PlantUmlParser.ACTIVITY, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StateDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDef; }
	}

	public final StateDefContext stateDef() throws RecognitionException {
		StateDefContext _localctx = new StateDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stateDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			state();
			setState(60);
			match(COLON);
			setState(61);
			match(ACTIVITY);
			setState(62);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldDeclrAndAssignmentContext extends StatementContext {
		public ParamContext p;
		public Token r;
		public TerminalNode ASSIGN_OP() { return getToken(PlantUmlParser.ASSIGN_OP, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode VALUE() { return getToken(PlantUmlParser.VALUE, 0); }
		public FieldDeclrAndAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class FieldDeclrAndExprAssignmentContext extends StatementContext {
		public ParamContext p;
		public ExpressionContext r;
		public TerminalNode ASSIGN_OP() { return getToken(PlantUmlParser.ASSIGN_OP, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldDeclrAndExprAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FieldDeclrAndExprAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((FieldDeclrAndExprAssignmentContext)_localctx).p = param();
				setState(65);
				match(ASSIGN_OP);
				setState(66);
				((FieldDeclrAndExprAssignmentContext)_localctx).r = expression(0);
				}
				break;
			case 2:
				_localctx = new FieldDeclrAndAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((FieldDeclrAndAssignmentContext)_localctx).p = param();
				setState(69);
				match(ASSIGN_OP);
				setState(70);
				((FieldDeclrAndAssignmentContext)_localctx).r = match(VALUE);
				}
				break;
			case 3:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionContext extends ParserRuleContext {
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	 
		public TransitionContext() { }
		public void copyFrom(TransitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TransPayContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public Token v;
		public UnitContext u;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(PlantUmlParser.NUMBER, 0); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TransPayContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class TransPayCondContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public Token v;
		public UnitContext u;
		public ConditionContext c;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(PlantUmlParser.NUMBER, 0); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TransPayCondContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class TransCondContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public ConditionContext c;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TransCondContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class TransContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public TransContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class TransPayStarCondContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public ConditionContext c;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TransPayStarCondContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class TransPayStarContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public Token i;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TransPayStarContext(TransitionContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyTransContext extends TransitionContext {
		public StateContext l;
		public StateContext r;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public EmptyTransContext(TransitionContext ctx) { copyFrom(ctx); }
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_transition);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new TransContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((TransContext)_localctx).l = state();
				setState(76);
				arrow();
				setState(77);
				((TransContext)_localctx).r = state();
				setState(78);
				match(COLON);
				setState(79);
				((TransContext)_localctx).i = match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new TransCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				((TransCondContext)_localctx).l = state();
				setState(82);
				arrow();
				setState(83);
				((TransCondContext)_localctx).r = state();
				setState(84);
				match(COLON);
				setState(85);
				((TransCondContext)_localctx).i = match(IDENTIFIER);
				setState(86);
				((TransCondContext)_localctx).c = condition();
				}
				break;
			case 3:
				_localctx = new TransPayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				((TransPayContext)_localctx).l = state();
				setState(89);
				arrow();
				setState(90);
				((TransPayContext)_localctx).r = state();
				setState(91);
				match(COLON);
				setState(92);
				((TransPayContext)_localctx).i = match(T__2);
				setState(93);
				((TransPayContext)_localctx).v = match(NUMBER);
				setState(94);
				((TransPayContext)_localctx).u = unit();
				}
				break;
			case 4:
				_localctx = new TransPayCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				((TransPayCondContext)_localctx).l = state();
				setState(97);
				arrow();
				setState(98);
				((TransPayCondContext)_localctx).r = state();
				setState(99);
				match(COLON);
				setState(100);
				((TransPayCondContext)_localctx).i = match(T__2);
				setState(101);
				((TransPayCondContext)_localctx).v = match(NUMBER);
				setState(102);
				((TransPayCondContext)_localctx).u = unit();
				setState(103);
				((TransPayCondContext)_localctx).c = condition();
				}
				break;
			case 5:
				_localctx = new TransPayStarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				((TransPayStarContext)_localctx).l = state();
				setState(106);
				arrow();
				setState(107);
				((TransPayStarContext)_localctx).r = state();
				setState(108);
				match(COLON);
				setState(109);
				((TransPayStarContext)_localctx).i = match(T__3);
				}
				break;
			case 6:
				_localctx = new TransPayStarCondContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
				((TransPayStarCondContext)_localctx).l = state();
				setState(112);
				arrow();
				setState(113);
				((TransPayStarCondContext)_localctx).r = state();
				setState(114);
				match(COLON);
				setState(115);
				((TransPayStarCondContext)_localctx).i = match(T__3);
				setState(116);
				((TransPayStarCondContext)_localctx).c = condition();
				}
				break;
			case 7:
				_localctx = new EmptyTransContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(118);
				((EmptyTransContext)_localctx).l = state();
				setState(119);
				arrow();
				setState(120);
				((EmptyTransContext)_localctx).r = state();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode BRACKET_OPEN() { return getToken(PlantUmlParser.BRACKET_OPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BRACKET_CLOSE() { return getToken(PlantUmlParser.BRACKET_CLOSE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(BRACKET_OPEN);
			setState(125);
			expression(0);
			setState(126);
			match(BRACKET_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOperatorContext extends ParserRuleContext {
		public TerminalNode OP_EQUAL() { return getToken(PlantUmlParser.OP_EQUAL, 0); }
		public TerminalNode OP_LT() { return getToken(PlantUmlParser.OP_LT, 0); }
		public TerminalNode OP_LTE() { return getToken(PlantUmlParser.OP_LTE, 0); }
		public TerminalNode OP_GT() { return getToken(PlantUmlParser.OP_GT, 0); }
		public TerminalNode OP_GTE() { return getToken(PlantUmlParser.OP_GTE, 0); }
		public CompOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOperator; }
	}

	public final CompOperatorContext compOperator() throws RecognitionException {
		CompOperatorContext _localctx = new CompOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_EQUAL) | (1L << OP_LT) | (1L << OP_LTE) | (1L << OP_GT) | (1L << OP_GTE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PlantUmlParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PlantUmlParser.MINUS, 0); }
		public TerminalNode DIVIDE() { return getToken(PlantUmlParser.DIVIDE, 0); }
		public TerminalNode MULT() { return getToken(PlantUmlParser.MULT, 0); }
		public MathOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathOperator; }
	}

	public final MathOperatorContext mathOperator() throws RecognitionException {
		MathOperatorContext _localctx = new MathOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mathOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << DIVIDE) | (1L << MULT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PlantUmlParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(PlantUmlParser.INTEGER, 0); }
		public TerminalNode UINTEGER() { return getToken(PlantUmlParser.UINTEGER, 0); }
		public TerminalNode ADDRESS() { return getToken(PlantUmlParser.ADDRESS, 0); }
		public TerminalNode BOOLEAN() { return getToken(PlantUmlParser.BOOLEAN, 0); }
		public TerminalNode BYTE_ARRAY() { return getToken(PlantUmlParser.BYTE_ARRAY, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PlantUmlParser.COMMA, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(133);
				match(STRING);
				}
				break;
			case INTEGER:
				{
				setState(134);
				match(INTEGER);
				}
				break;
			case UINTEGER:
				{
				setState(135);
				match(UINTEGER);
				}
				break;
			case ADDRESS:
				{
				setState(136);
				match(ADDRESS);
				}
				break;
			case BOOLEAN:
				{
				setState(137);
				match(BOOLEAN);
				}
				break;
			case BYTE_ARRAY:
				{
				setState(138);
				match(BYTE_ARRAY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(141);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(142);
					match(COMMA);
					setState(143);
					type(2);
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public TerminalNode ETHER() { return getToken(PlantUmlParser.ETHER, 0); }
		public TerminalNode WEI() { return getToken(PlantUmlParser.WEI, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==ETHER || _la==WEI) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeUnitContext extends ParserRuleContext {
		public TerminalNode DAYS() { return getToken(PlantUmlParser.DAYS, 0); }
		public TimeUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeUnit; }
	}

	public final TimeUnitContext timeUnit() throws RecognitionException {
		TimeUnitContext _localctx = new TimeUnitContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_timeUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(DAYS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode SOL_GLOBAL_VALUE() { return getToken(PlantUmlParser.SOL_GLOBAL_VALUE, 0); }
		public TerminalNode SOL_GLOBAL_DATE() { return getToken(PlantUmlParser.SOL_GLOBAL_DATE, 0); }
		public TerminalNode SOL_GLOBAL_DATE2() { return getToken(PlantUmlParser.SOL_GLOBAL_DATE2, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SOL_GLOBAL_VALUE) | (1L << SOL_GLOBAL_DATE) | (1L << SOL_GLOBAL_DATE2) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PlantUmlParser.NUMBER, 0); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TimeUnitContext timeUnit() {
			return getRuleContext(TimeUnitContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(NUMBER);
				setState(157);
				unit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(NUMBER);
				setState(159);
				timeUnit();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentContext extends ExpressionContext {
		public VariableContext l;
		public ExpressionContext r;
		public TerminalNode ASSIGN_OP() { return getToken(PlantUmlParser.ASSIGN_OP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class SentFromExprContext extends ExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SentFromExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class JustAVariableContext extends ExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public JustAVariableContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class CondORExprContext extends ExpressionContext {
		public ExpressionContext l;
		public Token op;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(PlantUmlParser.OR, 0); }
		public CondORExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MathOperationContext extends ExpressionContext {
		public ExpressionContext lv;
		public MathOperatorContext op;
		public ExpressionContext rv;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MathOperatorContext mathOperator() {
			return getRuleContext(MathOperatorContext.class,0);
		}
		public MathOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class CompOperationContext extends ExpressionContext {
		public ExpressionContext lv;
		public CompOperatorContext op;
		public ExpressionContext rv;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompOperatorContext compOperator() {
			return getRuleContext(CompOperatorContext.class,0);
		}
		public CompOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MethodCallContext extends ExpressionContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public MethodCallContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class CondExprContext extends ExpressionContext {
		public ExpressionContext l;
		public Token op;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PlantUmlParser.AND, 0); }
		public CondExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class JustAConstantContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public JustAConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(163);
				((AssignmentContext)_localctx).l = variable();
				setState(164);
				match(ASSIGN_OP);
				setState(165);
				((AssignmentContext)_localctx).r = expression(5);
				}
				break;
			case 2:
				{
				_localctx = new SentFromExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(T__4);
				setState(168);
				variable();
				}
				break;
			case 3:
				{
				_localctx = new JustAConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				constant();
				}
				break;
			case 4:
				{
				_localctx = new JustAVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				variable();
				}
				break;
			case 5:
				{
				_localctx = new MethodCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				method();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondExprContext(new ExpressionContext(_parentctx, _parentState));
						((CondExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(175);
						((CondExprContext)_localctx).op = match(AND);
						setState(176);
						((CondExprContext)_localctx).r = expression(10);
						}
						break;
					case 2:
						{
						_localctx = new CondORExprContext(new ExpressionContext(_parentctx, _parentState));
						((CondORExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(178);
						((CondORExprContext)_localctx).op = match(OR);
						setState(179);
						((CondORExprContext)_localctx).r = expression(9);
						}
						break;
					case 3:
						{
						_localctx = new MathOperationContext(new ExpressionContext(_parentctx, _parentState));
						((MathOperationContext)_localctx).lv = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(181);
						((MathOperationContext)_localctx).op = mathOperator();
						setState(182);
						((MathOperationContext)_localctx).rv = expression(8);
						}
						break;
					case 4:
						{
						_localctx = new CompOperationContext(new ExpressionContext(_parentctx, _parentState));
						((CompOperationContext)_localctx).lv = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(185);
						((CompOperationContext)_localctx).op = compOperator();
						setState(186);
						((CompOperationContext)_localctx).rv = expression(7);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Token id;
		public TypeContext t;
		public TerminalNode COLON() { return getToken(PlantUmlParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			((ParamContext)_localctx).id = match(IDENTIFIER);
			setState(194);
			match(COLON);
			setState(195);
			((ParamContext)_localctx).t = type(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	 
		public MethodContext() { }
		public void copyFrom(MethodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoParamMethContext extends MethodContext {
		public Token id;
		public TerminalNode CLOSURE() { return getToken(PlantUmlParser.CLOSURE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public NoParamMethContext(MethodContext ctx) { copyFrom(ctx); }
	}
	public static class ParamMethContext extends MethodContext {
		public Token id;
		public TerminalNode CLOSURE_OPEN() { return getToken(PlantUmlParser.CLOSURE_OPEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CLOSURE_CLOSE() { return getToken(PlantUmlParser.CLOSURE_CLOSE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PlantUmlParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PlantUmlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PlantUmlParser.COMMA, i);
		}
		public ParamMethContext(MethodContext ctx) { copyFrom(ctx); }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_method);
		int _la;
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new NoParamMethContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				((NoParamMethContext)_localctx).id = match(IDENTIFIER);
				setState(198);
				match(CLOSURE);
				}
				break;
			case 2:
				_localctx = new ParamMethContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				((ParamMethContext)_localctx).id = match(IDENTIFIER);
				setState(200);
				match(CLOSURE_OPEN);
				setState(201);
				expression(0);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(202);
					match(COMMA);
					setState(203);
					expression(0);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(CLOSURE_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrowContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(PlantUmlParser.ARROW, 0); }
		public TerminalNode LONG_ARROW() { return getToken(PlantUmlParser.LONG_ARROW, 0); }
		public TerminalNode LONG_ARROW_UP() { return getToken(PlantUmlParser.LONG_ARROW_UP, 0); }
		public TerminalNode LONG_ARROW_DOWN() { return getToken(PlantUmlParser.LONG_ARROW_DOWN, 0); }
		public TerminalNode LONG_ARROW_LEFT() { return getToken(PlantUmlParser.LONG_ARROW_LEFT, 0); }
		public TerminalNode LONG_ARROW_RIGHT() { return getToken(PlantUmlParser.LONG_ARROW_RIGHT, 0); }
		public ArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrow; }
	}

	public final ArrowContext arrow() throws RecognitionException {
		ArrowContext _localctx = new ArrowContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ARROW) | (1L << LONG_ARROW) | (1L << LONG_ARROW_UP) | (1L << LONG_ARROW_DOWN) | (1L << LONG_ARROW_LEFT) | (1L << LONG_ARROW_RIGHT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u008e\n\13\3\13\3\13\3\13\7\13\u0093\n"+
		"\13\f\13\16\13\u0096\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u00a3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00af\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00bf\n\20\f\20\16\20\u00c2\13\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00cf\n\22\f\22\16"+
		"\22\u00d2\13\22\3\22\3\22\5\22\u00d6\n\22\3\23\3\23\3\23\2\4\24\36\24"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\n\3\2\3\4\3\2$%\4\2\n\n"+
		"88\3\2\16\22\3\2\23\26\3\2&\'\4\2*,88\3\2-\62\2\u00e4\2&\3\2\2\2\4*\3"+
		"\2\2\2\6;\3\2\2\2\b=\3\2\2\2\nK\3\2\2\2\f|\3\2\2\2\16~\3\2\2\2\20\u0082"+
		"\3\2\2\2\22\u0084\3\2\2\2\24\u008d\3\2\2\2\26\u0097\3\2\2\2\30\u0099\3"+
		"\2\2\2\32\u009b\3\2\2\2\34\u00a2\3\2\2\2\36\u00ae\3\2\2\2 \u00c3\3\2\2"+
		"\2\"\u00d5\3\2\2\2$\u00d7\3\2\2\2&\'\7\65\2\2\'(\t\2\2\2()\t\3\2\2)\3"+
		"\3\2\2\2*+\7\b\2\2+/\78\2\2,.\5\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2"+
		"/\60\3\2\2\2\60\66\3\2\2\2\61/\3\2\2\2\62\65\5\b\5\2\63\65\5\f\7\2\64"+
		"\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679"+
		"\3\2\2\28\66\3\2\2\29:\7\t\2\2:\5\3\2\2\2;<\t\4\2\2<\7\3\2\2\2=>\5\6\4"+
		"\2>?\7\13\2\2?@\7\63\2\2@A\5\n\6\2A\t\3\2\2\2BC\5 \21\2CD\7\r\2\2DE\5"+
		"\36\20\2EL\3\2\2\2FG\5 \21\2GH\7\r\2\2HI\7:\2\2IL\3\2\2\2JL\5\36\20\2"+
		"KB\3\2\2\2KF\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MN\5\6\4\2NO\5$\23\2OP\5\6\4"+
		"\2PQ\7\13\2\2QR\78\2\2R}\3\2\2\2ST\5\6\4\2TU\5$\23\2UV\5\6\4\2VW\7\13"+
		"\2\2WX\78\2\2XY\5\16\b\2Y}\3\2\2\2Z[\5\6\4\2[\\\5$\23\2\\]\5\6\4\2]^\7"+
		"\13\2\2^_\7\5\2\2_`\7\66\2\2`a\5\26\f\2a}\3\2\2\2bc\5\6\4\2cd\5$\23\2"+
		"de\5\6\4\2ef\7\13\2\2fg\7\5\2\2gh\7\66\2\2hi\5\26\f\2ij\5\16\b\2j}\3\2"+
		"\2\2kl\5\6\4\2lm\5$\23\2mn\5\6\4\2no\7\13\2\2op\7\6\2\2p}\3\2\2\2qr\5"+
		"\6\4\2rs\5$\23\2st\5\6\4\2tu\7\13\2\2uv\7\6\2\2vw\5\16\b\2w}\3\2\2\2x"+
		"y\5\6\4\2yz\5$\23\2z{\5\6\4\2{}\3\2\2\2|M\3\2\2\2|S\3\2\2\2|Z\3\2\2\2"+
		"|b\3\2\2\2|k\3\2\2\2|q\3\2\2\2|x\3\2\2\2}\r\3\2\2\2~\177\7\27\2\2\177"+
		"\u0080\5\36\20\2\u0080\u0081\7\30\2\2\u0081\17\3\2\2\2\u0082\u0083\t\5"+
		"\2\2\u0083\21\3\2\2\2\u0084\u0085\t\6\2\2\u0085\23\3\2\2\2\u0086\u0087"+
		"\b\13\1\2\u0087\u008e\7\36\2\2\u0088\u008e\7\37\2\2\u0089\u008e\7 \2\2"+
		"\u008a\u008e\7!\2\2\u008b\u008e\7\"\2\2\u008c\u008e\7#\2\2\u008d\u0086"+
		"\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0094\3\2\2\2\u008f\u0090\f\3"+
		"\2\2\u0090\u0091\7\f\2\2\u0091\u0093\5\24\13\4\u0092\u008f\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\25\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\t\7\2\2\u0098\27\3\2\2\2\u0099\u009a"+
		"\7(\2\2\u009a\31\3\2\2\2\u009b\u009c\t\b\2\2\u009c\33\3\2\2\2\u009d\u00a3"+
		"\7\66\2\2\u009e\u009f\7\66\2\2\u009f\u00a3\5\26\f\2\u00a0\u00a1\7\66\2"+
		"\2\u00a1\u00a3\5\30\r\2\u00a2\u009d\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\35\3\2\2\2\u00a4\u00a5\b\20\1\2\u00a5\u00a6\5\32"+
		"\16\2\u00a6\u00a7\7\r\2\2\u00a7\u00a8\5\36\20\7\u00a8\u00af\3\2\2\2\u00a9"+
		"\u00aa\7\7\2\2\u00aa\u00af\5\32\16\2\u00ab\u00af\5\34\17\2\u00ac\u00af"+
		"\5\32\16\2\u00ad\u00af\5\"\22\2\u00ae\u00a4\3\2\2\2\u00ae\u00a9\3\2\2"+
		"\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00c0"+
		"\3\2\2\2\u00b0\u00b1\f\13\2\2\u00b1\u00b2\7\34\2\2\u00b2\u00bf\5\36\20"+
		"\f\u00b3\u00b4\f\n\2\2\u00b4\u00b5\7\35\2\2\u00b5\u00bf\5\36\20\13\u00b6"+
		"\u00b7\f\t\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00b9\5\36\20\n\u00b9\u00bf"+
		"\3\2\2\2\u00ba\u00bb\f\b\2\2\u00bb\u00bc\5\20\t\2\u00bc\u00bd\5\36\20"+
		"\t\u00bd\u00bf\3\2\2\2\u00be\u00b0\3\2\2\2\u00be\u00b3\3\2\2\2\u00be\u00b6"+
		"\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\37\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\78\2\2"+
		"\u00c4\u00c5\7\13\2\2\u00c5\u00c6\5\24\13\2\u00c6!\3\2\2\2\u00c7\u00c8"+
		"\78\2\2\u00c8\u00d6\7\33\2\2\u00c9\u00ca\78\2\2\u00ca\u00cb\7\31\2\2\u00cb"+
		"\u00d0\5\36\20\2\u00cc\u00cd\7\f\2\2\u00cd\u00cf\5\36\20\2\u00ce\u00cc"+
		"\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\32\2\2\u00d4\u00d6\3"+
		"\2\2\2\u00d5\u00c7\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d6#\3\2\2\2\u00d7\u00d8"+
		"\t\t\2\2\u00d8%\3\2\2\2\17/\64\66K|\u008d\u0094\u00a2\u00ae\u00be\u00c0"+
		"\u00d0\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}