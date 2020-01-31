// Generated from /home/andi/fhdo/Lehrveranstaltungen/Projektarbeit/Modellgetriebener Entwurf und Implementierung von Smart Contracts/grammar/plantuml.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class meismLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, ATTR=2, TYPE=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CLASS", "ATTR", "TYPE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "ATTR", "TYPE"
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


	public meismLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "plantuml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\59\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\25\n\3"+
		"\r\3\16\3\26\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"8\n\4\2\2\5\3\3\5\4\7\5\3\2\3\4\2C\\c|\2>\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\3\t\3\2\2\2\5\24\3\2\2\2\7\67\3\2\2\2\t\n\7e\2\2\n\13\7n\2\2"+
		"\13\f\7c\2\2\f\r\7u\2\2\r\16\7u\2\2\16\17\3\2\2\2\17\20\7}\2\2\20\21\5"+
		"\5\3\2\21\22\7\177\2\2\22\4\3\2\2\2\23\25\t\2\2\2\24\23\3\2\2\2\25\26"+
		"\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\31\7<\2\2\31\6\3"+
		"\2\2\2\32\33\7u\2\2\33\34\7v\2\2\34\35\7t\2\2\35\36\7k\2\2\36\37\7p\2"+
		"\2\378\7i\2\2 !\7k\2\2!\"\7p\2\2\"8\7v\2\2#$\7w\2\2$%\7k\2\2%&\7p\2\2"+
		"&8\7v\2\2\'(\7c\2\2()\7f\2\2)*\7f\2\2*+\7t\2\2+,\7g\2\2,-\7u\2\2-8\7u"+
		"\2\2./\7d\2\2/\60\7q\2\2\60\61\7q\2\2\618\7n\2\2\62\63\7d\2\2\63\64\7"+
		"{\2\2\64\65\7v\2\2\65\66\7g\2\2\668\7u\2\2\67\32\3\2\2\2\67 \3\2\2\2\67"+
		"#\3\2\2\2\67\'\3\2\2\2\67.\3\2\2\2\67\62\3\2\2\28\b\3\2\2\2\5\2\26\67"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}