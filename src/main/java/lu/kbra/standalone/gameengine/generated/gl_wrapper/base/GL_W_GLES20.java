package lu.kbra.standalone.gameengine.generated.gl_wrapper.base;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengles.GLES20;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W_Call;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public class GL_W_GLES20 implements GL_W_Call {
	public void init() {
		GL_W.WRAPPER = this;
		GL_W.GL_DEPTH_BUFFER_BIT = GLES20.GL_DEPTH_BUFFER_BIT;
		GL_W.GL_STENCIL_BUFFER_BIT = GLES20.GL_STENCIL_BUFFER_BIT;
		GL_W.GL_COLOR_BUFFER_BIT = GLES20.GL_COLOR_BUFFER_BIT;
		GL_W.GL_FALSE = GLES20.GL_FALSE;
		GL_W.GL_TRUE = GLES20.GL_TRUE;
		GL_W.GL_POINTS = GLES20.GL_POINTS;
		GL_W.GL_LINES = GLES20.GL_LINES;
		GL_W.GL_LINE_LOOP = GLES20.GL_LINE_LOOP;
		GL_W.GL_LINE_STRIP = GLES20.GL_LINE_STRIP;
		GL_W.GL_TRIANGLES = GLES20.GL_TRIANGLES;
		GL_W.GL_TRIANGLE_STRIP = GLES20.GL_TRIANGLE_STRIP;
		GL_W.GL_TRIANGLE_FAN = GLES20.GL_TRIANGLE_FAN;
		GL_W.GL_ZERO = GLES20.GL_ZERO;
		GL_W.GL_ONE = GLES20.GL_ONE;
		GL_W.GL_SRC_COLOR = GLES20.GL_SRC_COLOR;
		GL_W.GL_ONE_MINUS_SRC_COLOR = GLES20.GL_ONE_MINUS_SRC_COLOR;
		GL_W.GL_SRC_ALPHA = GLES20.GL_SRC_ALPHA;
		GL_W.GL_ONE_MINUS_SRC_ALPHA = GLES20.GL_ONE_MINUS_SRC_ALPHA;
		GL_W.GL_DST_ALPHA = GLES20.GL_DST_ALPHA;
		GL_W.GL_ONE_MINUS_DST_ALPHA = GLES20.GL_ONE_MINUS_DST_ALPHA;
		GL_W.GL_DST_COLOR = GLES20.GL_DST_COLOR;
		GL_W.GL_ONE_MINUS_DST_COLOR = GLES20.GL_ONE_MINUS_DST_COLOR;
		GL_W.GL_SRC_ALPHA_SATURATE = GLES20.GL_SRC_ALPHA_SATURATE;
		GL_W.GL_FUNC_ADD = GLES20.GL_FUNC_ADD;
		GL_W.GL_BLEND_EQUATION = GLES20.GL_BLEND_EQUATION;
		GL_W.GL_BLEND_EQUATION_RGB = GLES20.GL_BLEND_EQUATION_RGB;
		GL_W.GL_BLEND_EQUATION_ALPHA = GLES20.GL_BLEND_EQUATION_ALPHA;
		GL_W.GL_FUNC_SUBTRACT = GLES20.GL_FUNC_SUBTRACT;
		GL_W.GL_FUNC_REVERSE_SUBTRACT = GLES20.GL_FUNC_REVERSE_SUBTRACT;
		GL_W.GL_BLEND_DST_RGB = GLES20.GL_BLEND_DST_RGB;
		GL_W.GL_BLEND_SRC_RGB = GLES20.GL_BLEND_SRC_RGB;
		GL_W.GL_BLEND_DST_ALPHA = GLES20.GL_BLEND_DST_ALPHA;
		GL_W.GL_BLEND_SRC_ALPHA = GLES20.GL_BLEND_SRC_ALPHA;
		GL_W.GL_CONSTANT_COLOR = GLES20.GL_CONSTANT_COLOR;
		GL_W.GL_ONE_MINUS_CONSTANT_COLOR = GLES20.GL_ONE_MINUS_CONSTANT_COLOR;
		GL_W.GL_CONSTANT_ALPHA = GLES20.GL_CONSTANT_ALPHA;
		GL_W.GL_ONE_MINUS_CONSTANT_ALPHA = GLES20.GL_ONE_MINUS_CONSTANT_ALPHA;
		GL_W.GL_BLEND_COLOR = GLES20.GL_BLEND_COLOR;
		GL_W.GL_ARRAY_BUFFER = GLES20.GL_ARRAY_BUFFER;
		GL_W.GL_ELEMENT_ARRAY_BUFFER = GLES20.GL_ELEMENT_ARRAY_BUFFER;
		GL_W.GL_ARRAY_BUFFER_BINDING = GLES20.GL_ARRAY_BUFFER_BINDING;
		GL_W.GL_ELEMENT_ARRAY_BUFFER_BINDING = GLES20.GL_ELEMENT_ARRAY_BUFFER_BINDING;
		GL_W.GL_STREAM_DRAW = GLES20.GL_STREAM_DRAW;
		GL_W.GL_STATIC_DRAW = GLES20.GL_STATIC_DRAW;
		GL_W.GL_DYNAMIC_DRAW = GLES20.GL_DYNAMIC_DRAW;
		GL_W.GL_BUFFER_SIZE = GLES20.GL_BUFFER_SIZE;
		GL_W.GL_BUFFER_USAGE = GLES20.GL_BUFFER_USAGE;
		GL_W.GL_CURRENT_VERTEX_ATTRIB = GLES20.GL_CURRENT_VERTEX_ATTRIB;
		GL_W.GL_FRONT = GLES20.GL_FRONT;
		GL_W.GL_BACK = GLES20.GL_BACK;
		GL_W.GL_FRONT_AND_BACK = GLES20.GL_FRONT_AND_BACK;
		GL_W.GL_TEXTURE_2D = GLES20.GL_TEXTURE_2D;
		GL_W.GL_CULL_FACE = GLES20.GL_CULL_FACE;
		GL_W.GL_BLEND = GLES20.GL_BLEND;
		GL_W.GL_DITHER = GLES20.GL_DITHER;
		GL_W.GL_STENCIL_TEST = GLES20.GL_STENCIL_TEST;
		GL_W.GL_DEPTH_TEST = GLES20.GL_DEPTH_TEST;
		GL_W.GL_SCISSOR_TEST = GLES20.GL_SCISSOR_TEST;
		GL_W.GL_POLYGON_OFFSET_FILL = GLES20.GL_POLYGON_OFFSET_FILL;
		GL_W.GL_SAMPLE_ALPHA_TO_COVERAGE = GLES20.GL_SAMPLE_ALPHA_TO_COVERAGE;
		GL_W.GL_SAMPLE_COVERAGE = GLES20.GL_SAMPLE_COVERAGE;
		GL_W.GL_NO_ERROR = GLES20.GL_NO_ERROR;
		GL_W.GL_INVALID_ENUM = GLES20.GL_INVALID_ENUM;
		GL_W.GL_INVALID_VALUE = GLES20.GL_INVALID_VALUE;
		GL_W.GL_INVALID_OPERATION = GLES20.GL_INVALID_OPERATION;
		GL_W.GL_OUT_OF_MEMORY = GLES20.GL_OUT_OF_MEMORY;
		GL_W.GL_CW = GLES20.GL_CW;
		GL_W.GL_CCW = GLES20.GL_CCW;
		GL_W.GL_LINE_WIDTH = GLES20.GL_LINE_WIDTH;
		GL_W.GL_ALIASED_POINT_SIZE_RANGE = GLES20.GL_ALIASED_POINT_SIZE_RANGE;
		GL_W.GL_ALIASED_LINE_WIDTH_RANGE = GLES20.GL_ALIASED_LINE_WIDTH_RANGE;
		GL_W.GL_CULL_FACE_MODE = GLES20.GL_CULL_FACE_MODE;
		GL_W.GL_FRONT_FACE = GLES20.GL_FRONT_FACE;
		GL_W.GL_DEPTH_RANGE = GLES20.GL_DEPTH_RANGE;
		GL_W.GL_DEPTH_WRITEMASK = GLES20.GL_DEPTH_WRITEMASK;
		GL_W.GL_DEPTH_CLEAR_VALUE = GLES20.GL_DEPTH_CLEAR_VALUE;
		GL_W.GL_DEPTH_FUNC = GLES20.GL_DEPTH_FUNC;
		GL_W.GL_STENCIL_CLEAR_VALUE = GLES20.GL_STENCIL_CLEAR_VALUE;
		GL_W.GL_STENCIL_FUNC = GLES20.GL_STENCIL_FUNC;
		GL_W.GL_STENCIL_FAIL = GLES20.GL_STENCIL_FAIL;
		GL_W.GL_STENCIL_PASS_DEPTH_FAIL = GLES20.GL_STENCIL_PASS_DEPTH_FAIL;
		GL_W.GL_STENCIL_PASS_DEPTH_PASS = GLES20.GL_STENCIL_PASS_DEPTH_PASS;
		GL_W.GL_STENCIL_REF = GLES20.GL_STENCIL_REF;
		GL_W.GL_STENCIL_VALUE_MASK = GLES20.GL_STENCIL_VALUE_MASK;
		GL_W.GL_STENCIL_WRITEMASK = GLES20.GL_STENCIL_WRITEMASK;
		GL_W.GL_STENCIL_BACK_FUNC = GLES20.GL_STENCIL_BACK_FUNC;
		GL_W.GL_STENCIL_BACK_FAIL = GLES20.GL_STENCIL_BACK_FAIL;
		GL_W.GL_STENCIL_BACK_PASS_DEPTH_FAIL = GLES20.GL_STENCIL_BACK_PASS_DEPTH_FAIL;
		GL_W.GL_STENCIL_BACK_PASS_DEPTH_PASS = GLES20.GL_STENCIL_BACK_PASS_DEPTH_PASS;
		GL_W.GL_STENCIL_BACK_REF = GLES20.GL_STENCIL_BACK_REF;
		GL_W.GL_STENCIL_BACK_VALUE_MASK = GLES20.GL_STENCIL_BACK_VALUE_MASK;
		GL_W.GL_STENCIL_BACK_WRITEMASK = GLES20.GL_STENCIL_BACK_WRITEMASK;
		GL_W.GL_VIEWPORT = GLES20.GL_VIEWPORT;
		GL_W.GL_SCISSOR_BOX = GLES20.GL_SCISSOR_BOX;
		GL_W.GL_COLOR_CLEAR_VALUE = GLES20.GL_COLOR_CLEAR_VALUE;
		GL_W.GL_COLOR_WRITEMASK = GLES20.GL_COLOR_WRITEMASK;
		GL_W.GL_UNPACK_ALIGNMENT = GLES20.GL_UNPACK_ALIGNMENT;
		GL_W.GL_PACK_ALIGNMENT = GLES20.GL_PACK_ALIGNMENT;
		GL_W.GL_MAX_TEXTURE_SIZE = GLES20.GL_MAX_TEXTURE_SIZE;
		GL_W.GL_MAX_VIEWPORT_DIMS = GLES20.GL_MAX_VIEWPORT_DIMS;
		GL_W.GL_SUBPIXEL_BITS = GLES20.GL_SUBPIXEL_BITS;
		GL_W.GL_RED_BITS = GLES20.GL_RED_BITS;
		GL_W.GL_GREEN_BITS = GLES20.GL_GREEN_BITS;
		GL_W.GL_BLUE_BITS = GLES20.GL_BLUE_BITS;
		GL_W.GL_ALPHA_BITS = GLES20.GL_ALPHA_BITS;
		GL_W.GL_DEPTH_BITS = GLES20.GL_DEPTH_BITS;
		GL_W.GL_STENCIL_BITS = GLES20.GL_STENCIL_BITS;
		GL_W.GL_POLYGON_OFFSET_UNITS = GLES20.GL_POLYGON_OFFSET_UNITS;
		GL_W.GL_POLYGON_OFFSET_FACTOR = GLES20.GL_POLYGON_OFFSET_FACTOR;
		GL_W.GL_TEXTURE_BINDING_2D = GLES20.GL_TEXTURE_BINDING_2D;
		GL_W.GL_SAMPLE_BUFFERS = GLES20.GL_SAMPLE_BUFFERS;
		GL_W.GL_SAMPLES = GLES20.GL_SAMPLES;
		GL_W.GL_SAMPLE_COVERAGE_VALUE = GLES20.GL_SAMPLE_COVERAGE_VALUE;
		GL_W.GL_SAMPLE_COVERAGE_INVERT = GLES20.GL_SAMPLE_COVERAGE_INVERT;
		GL_W.GL_NUM_COMPRESSED_TEXTURE_FORMATS = GLES20.GL_NUM_COMPRESSED_TEXTURE_FORMATS;
		GL_W.GL_COMPRESSED_TEXTURE_FORMATS = GLES20.GL_COMPRESSED_TEXTURE_FORMATS;
		GL_W.GL_DONT_CARE = GLES20.GL_DONT_CARE;
		GL_W.GL_FASTEST = GLES20.GL_FASTEST;
		GL_W.GL_NICEST = GLES20.GL_NICEST;
		GL_W.GL_GENERATE_MIPMAP_HINT = GLES20.GL_GENERATE_MIPMAP_HINT;
		GL_W.GL_BYTE = GLES20.GL_BYTE;
		GL_W.GL_UNSIGNED_BYTE = GLES20.GL_UNSIGNED_BYTE;
		GL_W.GL_SHORT = GLES20.GL_SHORT;
		GL_W.GL_UNSIGNED_SHORT = GLES20.GL_UNSIGNED_SHORT;
		GL_W.GL_INT = GLES20.GL_INT;
		GL_W.GL_UNSIGNED_INT = GLES20.GL_UNSIGNED_INT;
		GL_W.GL_FLOAT = GLES20.GL_FLOAT;
		GL_W.GL_FIXED = GLES20.GL_FIXED;
		GL_W.GL_DEPTH_COMPONENT = GLES20.GL_DEPTH_COMPONENT;
		GL_W.GL_ALPHA = GLES20.GL_ALPHA;
		GL_W.GL_RGB = GLES20.GL_RGB;
		GL_W.GL_RGBA = GLES20.GL_RGBA;
		GL_W.GL_LUMINANCE = GLES20.GL_LUMINANCE;
		GL_W.GL_LUMINANCE_ALPHA = GLES20.GL_LUMINANCE_ALPHA;
		GL_W.GL_UNSIGNED_SHORT_4_4_4_4 = GLES20.GL_UNSIGNED_SHORT_4_4_4_4;
		GL_W.GL_UNSIGNED_SHORT_5_5_5_1 = GLES20.GL_UNSIGNED_SHORT_5_5_5_1;
		GL_W.GL_UNSIGNED_SHORT_5_6_5 = GLES20.GL_UNSIGNED_SHORT_5_6_5;
		GL_W.GL_FRAGMENT_SHADER = GLES20.GL_FRAGMENT_SHADER;
		GL_W.GL_VERTEX_SHADER = GLES20.GL_VERTEX_SHADER;
		GL_W.GL_MAX_VERTEX_ATTRIBS = GLES20.GL_MAX_VERTEX_ATTRIBS;
		GL_W.GL_MAX_VERTEX_UNIFORM_VECTORS = GLES20.GL_MAX_VERTEX_UNIFORM_VECTORS;
		GL_W.GL_MAX_VARYING_VECTORS = GLES20.GL_MAX_VARYING_VECTORS;
		GL_W.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;
		GL_W.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
		GL_W.GL_MAX_TEXTURE_IMAGE_UNITS = GLES20.GL_MAX_TEXTURE_IMAGE_UNITS;
		GL_W.GL_MAX_FRAGMENT_UNIFORM_VECTORS = GLES20.GL_MAX_FRAGMENT_UNIFORM_VECTORS;
		GL_W.GL_SHADER_TYPE = GLES20.GL_SHADER_TYPE;
		GL_W.GL_DELETE_STATUS = GLES20.GL_DELETE_STATUS;
		GL_W.GL_LINK_STATUS = GLES20.GL_LINK_STATUS;
		GL_W.GL_VALIDATE_STATUS = GLES20.GL_VALIDATE_STATUS;
		GL_W.GL_ATTACHED_SHADERS = GLES20.GL_ATTACHED_SHADERS;
		GL_W.GL_ACTIVE_UNIFORMS = GLES20.GL_ACTIVE_UNIFORMS;
		GL_W.GL_ACTIVE_UNIFORM_MAX_LENGTH = GLES20.GL_ACTIVE_UNIFORM_MAX_LENGTH;
		GL_W.GL_ACTIVE_ATTRIBUTES = GLES20.GL_ACTIVE_ATTRIBUTES;
		GL_W.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = GLES20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH;
		GL_W.GL_SHADING_LANGUAGE_VERSION = GLES20.GL_SHADING_LANGUAGE_VERSION;
		GL_W.GL_CURRENT_PROGRAM = GLES20.GL_CURRENT_PROGRAM;
		GL_W.GL_NEVER = GLES20.GL_NEVER;
		GL_W.GL_LESS = GLES20.GL_LESS;
		GL_W.GL_EQUAL = GLES20.GL_EQUAL;
		GL_W.GL_LEQUAL = GLES20.GL_LEQUAL;
		GL_W.GL_GREATER = GLES20.GL_GREATER;
		GL_W.GL_NOTEQUAL = GLES20.GL_NOTEQUAL;
		GL_W.GL_GEQUAL = GLES20.GL_GEQUAL;
		GL_W.GL_ALWAYS = GLES20.GL_ALWAYS;
		GL_W.GL_KEEP = GLES20.GL_KEEP;
		GL_W.GL_REPLACE = GLES20.GL_REPLACE;
		GL_W.GL_INCR = GLES20.GL_INCR;
		GL_W.GL_DECR = GLES20.GL_DECR;
		GL_W.GL_INVERT = GLES20.GL_INVERT;
		GL_W.GL_INCR_WRAP = GLES20.GL_INCR_WRAP;
		GL_W.GL_DECR_WRAP = GLES20.GL_DECR_WRAP;
		GL_W.GL_VENDOR = GLES20.GL_VENDOR;
		GL_W.GL_RENDERER = GLES20.GL_RENDERER;
		GL_W.GL_VERSION = GLES20.GL_VERSION;
		GL_W.GL_EXTENSIONS = GLES20.GL_EXTENSIONS;
		GL_W.GL_NEAREST = GLES20.GL_NEAREST;
		GL_W.GL_LINEAR = GLES20.GL_LINEAR;
		GL_W.GL_NEAREST_MIPMAP_NEAREST = GLES20.GL_NEAREST_MIPMAP_NEAREST;
		GL_W.GL_LINEAR_MIPMAP_NEAREST = GLES20.GL_LINEAR_MIPMAP_NEAREST;
		GL_W.GL_NEAREST_MIPMAP_LINEAR = GLES20.GL_NEAREST_MIPMAP_LINEAR;
		GL_W.GL_LINEAR_MIPMAP_LINEAR = GLES20.GL_LINEAR_MIPMAP_LINEAR;
		GL_W.GL_TEXTURE_MAG_FILTER = GLES20.GL_TEXTURE_MAG_FILTER;
		GL_W.GL_TEXTURE_MIN_FILTER = GLES20.GL_TEXTURE_MIN_FILTER;
		GL_W.GL_TEXTURE_WRAP_S = GLES20.GL_TEXTURE_WRAP_S;
		GL_W.GL_TEXTURE_WRAP_T = GLES20.GL_TEXTURE_WRAP_T;
		GL_W.GL_TEXTURE = GLES20.GL_TEXTURE;
		GL_W.GL_TEXTURE_CUBE_MAP = GLES20.GL_TEXTURE_CUBE_MAP;
		GL_W.GL_TEXTURE_BINDING_CUBE_MAP = GLES20.GL_TEXTURE_BINDING_CUBE_MAP;
		GL_W.GL_TEXTURE_CUBE_MAP_POSITIVE_X = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
		GL_W.GL_TEXTURE_CUBE_MAP_NEGATIVE_X = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
		GL_W.GL_TEXTURE_CUBE_MAP_POSITIVE_Y = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
		GL_W.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
		GL_W.GL_TEXTURE_CUBE_MAP_POSITIVE_Z = GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
		GL_W.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;
		GL_W.GL_MAX_CUBE_MAP_TEXTURE_SIZE = GLES20.GL_MAX_CUBE_MAP_TEXTURE_SIZE;
		GL_W.GL_TEXTURE0 = GLES20.GL_TEXTURE0;
		GL_W.GL_TEXTURE1 = GLES20.GL_TEXTURE1;
		GL_W.GL_TEXTURE2 = GLES20.GL_TEXTURE2;
		GL_W.GL_TEXTURE3 = GLES20.GL_TEXTURE3;
		GL_W.GL_TEXTURE4 = GLES20.GL_TEXTURE4;
		GL_W.GL_TEXTURE5 = GLES20.GL_TEXTURE5;
		GL_W.GL_TEXTURE6 = GLES20.GL_TEXTURE6;
		GL_W.GL_TEXTURE7 = GLES20.GL_TEXTURE7;
		GL_W.GL_TEXTURE8 = GLES20.GL_TEXTURE8;
		GL_W.GL_TEXTURE9 = GLES20.GL_TEXTURE9;
		GL_W.GL_TEXTURE10 = GLES20.GL_TEXTURE10;
		GL_W.GL_TEXTURE11 = GLES20.GL_TEXTURE11;
		GL_W.GL_TEXTURE12 = GLES20.GL_TEXTURE12;
		GL_W.GL_TEXTURE13 = GLES20.GL_TEXTURE13;
		GL_W.GL_TEXTURE14 = GLES20.GL_TEXTURE14;
		GL_W.GL_TEXTURE15 = GLES20.GL_TEXTURE15;
		GL_W.GL_TEXTURE16 = GLES20.GL_TEXTURE16;
		GL_W.GL_TEXTURE17 = GLES20.GL_TEXTURE17;
		GL_W.GL_TEXTURE18 = GLES20.GL_TEXTURE18;
		GL_W.GL_TEXTURE19 = GLES20.GL_TEXTURE19;
		GL_W.GL_TEXTURE20 = GLES20.GL_TEXTURE20;
		GL_W.GL_TEXTURE21 = GLES20.GL_TEXTURE21;
		GL_W.GL_TEXTURE22 = GLES20.GL_TEXTURE22;
		GL_W.GL_TEXTURE23 = GLES20.GL_TEXTURE23;
		GL_W.GL_TEXTURE24 = GLES20.GL_TEXTURE24;
		GL_W.GL_TEXTURE25 = GLES20.GL_TEXTURE25;
		GL_W.GL_TEXTURE26 = GLES20.GL_TEXTURE26;
		GL_W.GL_TEXTURE27 = GLES20.GL_TEXTURE27;
		GL_W.GL_TEXTURE28 = GLES20.GL_TEXTURE28;
		GL_W.GL_TEXTURE29 = GLES20.GL_TEXTURE29;
		GL_W.GL_TEXTURE30 = GLES20.GL_TEXTURE30;
		GL_W.GL_TEXTURE31 = GLES20.GL_TEXTURE31;
		GL_W.GL_ACTIVE_TEXTURE = GLES20.GL_ACTIVE_TEXTURE;
		GL_W.GL_REPEAT = GLES20.GL_REPEAT;
		GL_W.GL_CLAMP_TO_EDGE = GLES20.GL_CLAMP_TO_EDGE;
		GL_W.GL_MIRRORED_REPEAT = GLES20.GL_MIRRORED_REPEAT;
		GL_W.GL_FLOAT_VEC2 = GLES20.GL_FLOAT_VEC2;
		GL_W.GL_FLOAT_VEC3 = GLES20.GL_FLOAT_VEC3;
		GL_W.GL_FLOAT_VEC4 = GLES20.GL_FLOAT_VEC4;
		GL_W.GL_INT_VEC2 = GLES20.GL_INT_VEC2;
		GL_W.GL_INT_VEC3 = GLES20.GL_INT_VEC3;
		GL_W.GL_INT_VEC4 = GLES20.GL_INT_VEC4;
		GL_W.GL_BOOL = GLES20.GL_BOOL;
		GL_W.GL_BOOL_VEC2 = GLES20.GL_BOOL_VEC2;
		GL_W.GL_BOOL_VEC3 = GLES20.GL_BOOL_VEC3;
		GL_W.GL_BOOL_VEC4 = GLES20.GL_BOOL_VEC4;
		GL_W.GL_FLOAT_MAT2 = GLES20.GL_FLOAT_MAT2;
		GL_W.GL_FLOAT_MAT3 = GLES20.GL_FLOAT_MAT3;
		GL_W.GL_FLOAT_MAT4 = GLES20.GL_FLOAT_MAT4;
		GL_W.GL_SAMPLER_2D = GLES20.GL_SAMPLER_2D;
		GL_W.GL_SAMPLER_CUBE = GLES20.GL_SAMPLER_CUBE;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_ENABLED = GLES20.GL_VERTEX_ATTRIB_ARRAY_ENABLED;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_SIZE = GLES20.GL_VERTEX_ATTRIB_ARRAY_SIZE;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_STRIDE = GLES20.GL_VERTEX_ATTRIB_ARRAY_STRIDE;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_TYPE = GLES20.GL_VERTEX_ATTRIB_ARRAY_TYPE;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = GLES20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_POINTER = GLES20.GL_VERTEX_ATTRIB_ARRAY_POINTER;
		GL_W.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = GLES20.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
		GL_W.GL_IMPLEMENTATION_COLOR_READ_TYPE = GLES20.GL_IMPLEMENTATION_COLOR_READ_TYPE;
		GL_W.GL_IMPLEMENTATION_COLOR_READ_FORMAT = GLES20.GL_IMPLEMENTATION_COLOR_READ_FORMAT;
		GL_W.GL_COMPILE_STATUS = GLES20.GL_COMPILE_STATUS;
		GL_W.GL_INFO_LOG_LENGTH = GLES20.GL_INFO_LOG_LENGTH;
		GL_W.GL_SHADER_SOURCE_LENGTH = GLES20.GL_SHADER_SOURCE_LENGTH;
		GL_W.GL_SHADER_COMPILER = GLES20.GL_SHADER_COMPILER;
		GL_W.GL_SHADER_BINARY_FORMATS = GLES20.GL_SHADER_BINARY_FORMATS;
		GL_W.GL_NUM_SHADER_BINARY_FORMATS = GLES20.GL_NUM_SHADER_BINARY_FORMATS;
		GL_W.GL_LOW_FLOAT = GLES20.GL_LOW_FLOAT;
		GL_W.GL_MEDIUM_FLOAT = GLES20.GL_MEDIUM_FLOAT;
		GL_W.GL_HIGH_FLOAT = GLES20.GL_HIGH_FLOAT;
		GL_W.GL_LOW_INT = GLES20.GL_LOW_INT;
		GL_W.GL_MEDIUM_INT = GLES20.GL_MEDIUM_INT;
		GL_W.GL_HIGH_INT = GLES20.GL_HIGH_INT;
		GL_W.GL_FRAMEBUFFER = GLES20.GL_FRAMEBUFFER;
		GL_W.GL_RENDERBUFFER = GLES20.GL_RENDERBUFFER;
		GL_W.GL_RGBA4 = GLES20.GL_RGBA4;
		GL_W.GL_RGB5_A1 = GLES20.GL_RGB5_A1;
		GL_W.GL_RGB565 = GLES20.GL_RGB565;
		GL_W.GL_DEPTH_COMPONENT16 = GLES20.GL_DEPTH_COMPONENT16;
		GL_W.GL_STENCIL_INDEX8 = GLES20.GL_STENCIL_INDEX8;
		GL_W.GL_RENDERBUFFER_WIDTH = GLES20.GL_RENDERBUFFER_WIDTH;
		GL_W.GL_RENDERBUFFER_HEIGHT = GLES20.GL_RENDERBUFFER_HEIGHT;
		GL_W.GL_RENDERBUFFER_INTERNAL_FORMAT = GLES20.GL_RENDERBUFFER_INTERNAL_FORMAT;
		GL_W.GL_RENDERBUFFER_RED_SIZE = GLES20.GL_RENDERBUFFER_RED_SIZE;
		GL_W.GL_RENDERBUFFER_GREEN_SIZE = GLES20.GL_RENDERBUFFER_GREEN_SIZE;
		GL_W.GL_RENDERBUFFER_BLUE_SIZE = GLES20.GL_RENDERBUFFER_BLUE_SIZE;
		GL_W.GL_RENDERBUFFER_ALPHA_SIZE = GLES20.GL_RENDERBUFFER_ALPHA_SIZE;
		GL_W.GL_RENDERBUFFER_DEPTH_SIZE = GLES20.GL_RENDERBUFFER_DEPTH_SIZE;
		GL_W.GL_RENDERBUFFER_STENCIL_SIZE = GLES20.GL_RENDERBUFFER_STENCIL_SIZE;
		GL_W.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = GLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
		GL_W.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = GLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
		GL_W.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = GLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
		GL_W.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = GLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
		GL_W.GL_COLOR_ATTACHMENT0 = GLES20.GL_COLOR_ATTACHMENT0;
		GL_W.GL_DEPTH_ATTACHMENT = GLES20.GL_DEPTH_ATTACHMENT;
		GL_W.GL_STENCIL_ATTACHMENT = GLES20.GL_STENCIL_ATTACHMENT;
		GL_W.GL_NONE = GLES20.GL_NONE;
		GL_W.GL_FRAMEBUFFER_COMPLETE = GLES20.GL_FRAMEBUFFER_COMPLETE;
		GL_W.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = GLES20.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
		GL_W.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = GLES20.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
		GL_W.GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS = GLES20.GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
		GL_W.GL_FRAMEBUFFER_UNSUPPORTED = GLES20.GL_FRAMEBUFFER_UNSUPPORTED;
		GL_W.GL_FRAMEBUFFER_BINDING = GLES20.GL_FRAMEBUFFER_BINDING;
		GL_W.GL_RENDERBUFFER_BINDING = GLES20.GL_RENDERBUFFER_BINDING;
		GL_W.GL_MAX_RENDERBUFFER_SIZE = GLES20.GL_MAX_RENDERBUFFER_SIZE;
		GL_W.GL_INVALID_FRAMEBUFFER_OPERATION = GLES20.GL_INVALID_FRAMEBUFFER_OPERATION;
	}

	@Override
	public void nglDeleteRenderbuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglDeleteRenderbuffers(arg0, arg1);
	}

	@Override
	public void glUniform1iv(int arg0, int[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform1iv(arg0, arg1);
	}

	@Override
	public void glUniform1iv(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform1iv(arg0, arg1);
	}

	@Override
	public void glBindRenderbuffer(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBindRenderbuffer(arg0, arg1);
	}

	@Override
	public int glGetRenderbufferParameteri(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetRenderbufferParameteri(arg0, arg1);
	}

	@Override
	public void nglGetFramebufferAttachmentParameteriv(int arg0, int arg1, int arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glGenFramebuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glGenFramebuffers(arg0);
	}

	@Override
	public void glGenFramebuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glGenFramebuffers(arg0);
	}

	@Override
	public int glGenFramebuffers() {
		return org.lwjgl.opengles.GLES20.glGenFramebuffers();
	}

	@Override
	public long glGetVertexAttribPointer(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetVertexAttribPointer(arg0, arg1);
	}

	@Override
	public void glHint(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glHint(arg0, arg1);
	}

	@Override
	public void glDeleteFramebuffers(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteFramebuffers(arg0);
	}

	@Override
	public void glDeleteFramebuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glDeleteFramebuffers(arg0);
	}

	@Override
	public void glDeleteFramebuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glDeleteFramebuffers(arg0);
	}

	@Override
	public void nglGetAttachedShaders(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetAttachedShaders(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glUniform1fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform1fv(arg0, arg1);
	}

	@Override
	public void glUniform1fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform1fv(arg0, arg1);
	}

	@Override
	public void glGetShaderiv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderiv(arg0, arg1, arg2);
	}

	@Override
	public void glGetShaderiv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderiv(arg0, arg1, arg2);
	}

	@Override
	public int glGetProgrami(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetProgrami(arg0, arg1);
	}

	@Override
	public String glGetActiveUniform_String(int arg0, int arg1, int arg2, IntBuffer arg3, IntBuffer arg4) {
		return org.lwjgl.opengles.GLES20.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void glGetActiveUniform(int arg0, int arg1, int[] arg2, int[] arg3, int[] arg4, ByteBuffer arg5) {
		org.lwjgl.opengles.GLES20.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glGetActiveUniform(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4,
			ByteBuffer arg5) {
		org.lwjgl.opengles.GLES20.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public String glGetActiveUniform_String(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3) {
		return org.lwjgl.opengles.GLES20.glGetActiveUniform(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glColorMask(boolean arg0, boolean arg1, boolean arg2, boolean arg3) {
		org.lwjgl.opengles.GLES20.glColorMask(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glVertexAttrib1fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib1fv(arg0, arg1);
	}

	@Override
	public void glVertexAttrib1fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib1fv(arg0, arg1);
	}

	@Override
	public void glBindTexture(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBindTexture(arg0, arg1);
	}

	@Override
	public void glPolygonOffset(float arg0, float arg1) {
		org.lwjgl.opengles.GLES20.glPolygonOffset(arg0, arg1);
	}

	@Override
	public int nglGetUniformLocation(int arg0, long arg1) {
		return org.lwjgl.opengles.GLES20.nglGetUniformLocation(arg0, arg1);
	}

	@Override
	public void glUniformMatrix3fv(int arg0, boolean arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix3fv(arg0, arg1, arg2);
	}

	@Override
	public void glUniformMatrix3fv(int arg0, boolean arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix3fv(arg0, arg1, arg2);
	}

	@Override
	public void nglUniformMatrix3fv(int arg0, int arg1, boolean arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglUniformMatrix3fv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glFlush() {
		org.lwjgl.opengles.GLES20.glFlush();
	}

	@Override
	public void glTexParameterf(int arg0, int arg1, float arg2) {
		org.lwjgl.opengles.GLES20.glTexParameterf(arg0, arg1, arg2);
	}

	@Override
	public boolean glIsBuffer(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsBuffer(arg0);
	}

	@Override
	public void nglVertexAttrib1fv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglVertexAttrib1fv(arg0, arg1);
	}

	@Override
	public void glValidateProgram(int arg0) {
		org.lwjgl.opengles.GLES20.glValidateProgram(arg0);
	}

	@Override
	public void nglGenTextures(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGenTextures(arg0, arg1);
	}

	@Override
	public void nglUniform1fv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform1fv(arg0, arg1, arg2);
	}

	@Override
	public void glTexParameteri(int arg0, int arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glTexParameteri(arg0, arg1, arg2);
	}

	@Override
	public int glCreateProgram() {
		return org.lwjgl.opengles.GLES20.glCreateProgram();
	}

	@Override
	public void glCullFace(int arg0) {
		org.lwjgl.opengles.GLES20.glCullFace(arg0);
	}

	@Override
	public void nglCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
			long arg7) {
		org.lwjgl.opengles.GLES20.nglCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void nglUniform1iv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform1iv(arg0, arg1, arg2);
	}

	@Override
	public void glDepthRangef(float arg0, float arg1) {
		org.lwjgl.opengles.GLES20.glDepthRangef(arg0, arg1);
	}

	@Override
	public void glDisable(int arg0) {
		org.lwjgl.opengles.GLES20.glDisable(arg0);
	}

	@Override
	public void glUniform4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
		org.lwjgl.opengles.GLES20.glUniform4f(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void nglGenFramebuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGenFramebuffers(arg0, arg1);
	}

	@Override
	public void glUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4) {
		org.lwjgl.opengles.GLES20.glUniform4i(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void glDeleteRenderbuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glDeleteRenderbuffers(arg0);
	}

	@Override
	public void glDeleteRenderbuffers(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteRenderbuffers(arg0);
	}

	@Override
	public void glDeleteRenderbuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glDeleteRenderbuffers(arg0);
	}

	@Override
	public void glGetProgramiv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetProgramiv(arg0, arg1, arg2);
	}

	@Override
	public void glGetProgramiv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetProgramiv(arg0, arg1, arg2);
	}

	@Override
	public void glGenTextures(int[] arg0) {
		org.lwjgl.opengles.GLES20.glGenTextures(arg0);
	}

	@Override
	public int glGenTextures() {
		return org.lwjgl.opengles.GLES20.glGenTextures();
	}

	@Override
	public void glGenTextures(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glGenTextures(arg0);
	}

	@Override
	public void glGetShaderPrecisionFormat(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3) {
		org.lwjgl.opengles.GLES20.glGetShaderPrecisionFormat(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glGetShaderPrecisionFormat(int arg0, int arg1, int[] arg2, int[] arg3) {
		org.lwjgl.opengles.GLES20.glGetShaderPrecisionFormat(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean glIsProgram(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsProgram(arg0);
	}

	@Override
	public void nglGetProgramInfoLog(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetProgramInfoLog(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglDrawElements(int arg0, int arg1, int arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglDrawElements(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glBindAttribLocation(int arg0, int arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glBindAttribLocation(arg0, arg1, arg2);
	}

	@Override
	public void glBindAttribLocation(int arg0, int arg1, CharSequence arg2) {
		org.lwjgl.opengles.GLES20.glBindAttribLocation(arg0, arg1, arg2);
	}

	@Override
	public void nglTexParameterfv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
			ByteBuffer arg7) {
		org.lwjgl.opengles.GLES20.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
			int arg7, long arg8) {
		org.lwjgl.opengles.GLES20.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void nglGetVertexAttribPointerv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetVertexAttribPointerv(arg0, arg1, arg2);
	}

	@Override
	public void glEnableVertexAttribArray(int arg0) {
		org.lwjgl.opengles.GLES20.glEnableVertexAttribArray(arg0);
	}

	@Override
	public void nglTexParameteriv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void nglGetIntegerv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGetIntegerv(arg0, arg1);
	}

	@Override
	public void glClear(int arg0) {
		org.lwjgl.opengles.GLES20.glClear(arg0);
	}

	@Override
	public void nglGenBuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGenBuffers(arg0, arg1);
	}

	@Override
	public void glGetFramebufferAttachmentParameteriv(int arg0, int arg1, int arg2, IntBuffer arg3) {
		org.lwjgl.opengles.GLES20.glGetFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glGetFramebufferAttachmentParameteriv(int arg0, int arg1, int arg2, int[] arg3) {
		org.lwjgl.opengles.GLES20.glGetFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glGenRenderbuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glGenRenderbuffers(arg0);
	}

	@Override
	public void glGenRenderbuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glGenRenderbuffers(arg0);
	}

	@Override
	public int glGenRenderbuffers() {
		return org.lwjgl.opengles.GLES20.glGenRenderbuffers();
	}

	@Override
	public void glCompileShader(int arg0) {
		org.lwjgl.opengles.GLES20.glCompileShader(arg0);
	}

	@Override
	public boolean glIsRenderbuffer(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsRenderbuffer(arg0);
	}

	@Override
	public void nglUniformMatrix4fv(int arg0, int arg1, boolean arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglUniformMatrix4fv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglVertexAttrib4fv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglVertexAttrib4fv(arg0, arg1);
	}

	@Override
	public void glUniform4fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform4fv(arg0, arg1);
	}

	@Override
	public void glUniform4fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform4fv(arg0, arg1);
	}

	@Override
	public void glViewport(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glViewport(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglDeleteFramebuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglDeleteFramebuffers(arg0, arg1);
	}

	@Override
	public void nglGetActiveUniform(int arg0, int arg1, int arg2, long arg3, long arg4, long arg5, long arg6) {
		org.lwjgl.opengles.GLES20.nglGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void nglGetUniformiv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetUniformiv(arg0, arg1, arg2);
	}

	@Override
	public void glUniform4iv(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform4iv(arg0, arg1);
	}

	@Override
	public void glUniform4iv(int arg0, int[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform4iv(arg0, arg1);
	}

	@Override
	public void glDepthMask(boolean arg0) {
		org.lwjgl.opengles.GLES20.glDepthMask(arg0);
	}

	@Override
	public void glUseProgram(int arg0) {
		org.lwjgl.opengles.GLES20.glUseProgram(arg0);
	}

	@Override
	public void glUniformMatrix4fv(int arg0, boolean arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix4fv(arg0, arg1, arg2);
	}

	@Override
	public void glUniformMatrix4fv(int arg0, boolean arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix4fv(arg0, arg1, arg2);
	}

	@Override
	public void nglGetUniformfv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetUniformfv(arg0, arg1, arg2);
	}

	@Override
	public void glSampleCoverage(float arg0, boolean arg1) {
		org.lwjgl.opengles.GLES20.glSampleCoverage(arg0, arg1);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			short[] arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			int[] arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			ShortBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			IntBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			FloatBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			float[] arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			ByteBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			long arg8) {
		org.lwjgl.opengles.GLES20.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glDeleteShader(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteShader(arg0);
	}

	@Override
	public void glVertexAttrib4fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib4fv(arg0, arg1);
	}

	@Override
	public void glVertexAttrib4fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib4fv(arg0, arg1);
	}

	@Override
	public void nglGetShaderInfoLog(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetShaderInfoLog(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glDrawArrays(int arg0, int arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glDrawArrays(arg0, arg1, arg2);
	}

	@Override
	public void nglShaderSource(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglShaderSource(arg0, arg1, arg2, arg3);
	}

	@Override
	public int nglGetAttribLocation(int arg0, long arg1) {
		return org.lwjgl.opengles.GLES20.nglGetAttribLocation(arg0, arg1);
	}

	@Override
	public void glStencilOp(int arg0, int arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glStencilOp(arg0, arg1, arg2);
	}

	@Override
	public float glGetUniformf(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetUniformf(arg0, arg1);
	}

	@Override
	public int glGetUniformi(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetUniformi(arg0, arg1);
	}

	@Override
	public void glBindBuffer(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBindBuffer(arg0, arg1);
	}

	@Override
	public void nglTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			long arg8) {
		org.lwjgl.opengles.GLES20.nglTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public boolean glIsTexture(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsTexture(arg0);
	}

	@Override
	public void glFramebufferTexture2D(int arg0, int arg1, int arg2, int arg3, int arg4) {
		org.lwjgl.opengles.GLES20.glFramebufferTexture2D(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void glEnable(int arg0) {
		org.lwjgl.opengles.GLES20.glEnable(arg0);
	}

	@Override
	public void nglUniform2fv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform2fv(arg0, arg1, arg2);
	}

	@Override
	public void glGetFloatv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glGetFloatv(arg0, arg1);
	}

	@Override
	public void glGetFloatv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glGetFloatv(arg0, arg1);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, FloatBuffer arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, short[] arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, float[] arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, IntBuffer arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ShortBuffer arg6) {
		org.lwjgl.opengles.GLES20.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glFrontFace(int arg0) {
		org.lwjgl.opengles.GLES20.glFrontFace(arg0);
	}

	@Override
	public void nglUniform2iv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform2iv(arg0, arg1, arg2);
	}

	@Override
	public int glGetFramebufferAttachmentParameteri(int arg0, int arg1, int arg2) {
		return org.lwjgl.opengles.GLES20.glGetFramebufferAttachmentParameteri(arg0, arg1, arg2);
	}

	@Override
	public void glGetAttachedShaders(int arg0, int[] arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetAttachedShaders(arg0, arg1, arg2);
	}

	@Override
	public void glGetAttachedShaders(int arg0, IntBuffer arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetAttachedShaders(arg0, arg1, arg2);
	}

	@Override
	public void glClearStencil(int arg0) {
		org.lwjgl.opengles.GLES20.glClearStencil(arg0);
	}

	@Override
	public void glTexParameteriv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glTexParameteriv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glShaderBinary(IntBuffer arg0, int arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glShaderBinary(arg0, arg1, arg2);
	}

	@Override
	public void glShaderBinary(int[] arg0, int arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glShaderBinary(arg0, arg1, arg2);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			float[] arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			int[] arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			short[] arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			ByteBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			long arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			ShortBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			IntBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			FloatBuffer arg8) {
		org.lwjgl.opengles.GLES20.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void nglDeleteTextures(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglDeleteTextures(arg0, arg1);
	}

	@Override
	public void glBlendFuncSeparate(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glBlendFuncSeparate(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glBufferData(int arg0, float[] arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, long arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, ByteBuffer arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, int[] arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, short[] arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, IntBuffer arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, FloatBuffer arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferData(int arg0, ShortBuffer arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glBufferData(arg0, arg1, arg2);
	}

	@Override
	public void glDetachShader(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glDetachShader(arg0, arg1);
	}

	@Override
	public void glGetBufferParameteriv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetBufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glGetBufferParameteriv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetBufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public String glGetProgramInfoLog_String(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetProgramInfoLog(arg0);
	}

	@Override
	public String glGetProgramInfoLog_String(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetProgramInfoLog(arg0, arg1);
	}

	@Override
	public void glGetProgramInfoLog(int arg0, IntBuffer arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetProgramInfoLog(arg0, arg1, arg2);
	}

	@Override
	public void glGetProgramInfoLog(int arg0, int[] arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetProgramInfoLog(arg0, arg1, arg2);
	}

	@Override
	public void glStencilMaskSeparate(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glStencilMaskSeparate(arg0, arg1);
	}

	@Override
	public boolean glGetBoolean(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetBoolean(arg0);
	}

	@Override
	public void nglGetVertexAttribiv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetVertexAttribiv(arg0, arg1, arg2);
	}

	@Override
	public void glLineWidth(float arg0) {
		org.lwjgl.opengles.GLES20.glLineWidth(arg0);
	}

	@Override
	public void nglGetShaderSource(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetShaderSource(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, FloatBuffer arg5) {
		org.lwjgl.opengles.GLES20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, long arg5) {
		org.lwjgl.opengles.GLES20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, IntBuffer arg5) {
		org.lwjgl.opengles.GLES20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, ShortBuffer arg5) {
		org.lwjgl.opengles.GLES20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, ByteBuffer arg5) {
		org.lwjgl.opengles.GLES20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public int glGetShaderi(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetShaderi(arg0, arg1);
	}

	@Override
	public void nglCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
			int arg7, long arg8) {
		org.lwjgl.opengles.GLES20.nglCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glDrawElements(int arg0, int arg1, int arg2, long arg3) {
		org.lwjgl.opengles.GLES20.glDrawElements(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glDrawElements(int arg0, int arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glDrawElements(arg0, arg1, arg2);
	}

	@Override
	public void glDrawElements(int arg0, ByteBuffer arg1) {
		org.lwjgl.opengles.GLES20.glDrawElements(arg0, arg1);
	}

	@Override
	public void glDrawElements(int arg0, ShortBuffer arg1) {
		org.lwjgl.opengles.GLES20.glDrawElements(arg0, arg1);
	}

	@Override
	public void glDrawElements(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glDrawElements(arg0, arg1);
	}

	@Override
	public void glBlendFunc(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBlendFunc(arg0, arg1);
	}

	@Override
	public void glUniform3iv(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform3iv(arg0, arg1);
	}

	@Override
	public void glUniform3iv(int arg0, int[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform3iv(arg0, arg1);
	}

	@Override
	public void nglGetTexParameterfv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public void nglBindAttribLocation(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglBindAttribLocation(arg0, arg1, arg2);
	}

	@Override
	public void glDeleteProgram(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteProgram(arg0);
	}

	@Override
	public void glGetIntegerv(int arg0, int[] arg1) {
		org.lwjgl.opengles.GLES20.glGetIntegerv(arg0, arg1);
	}

	@Override
	public void glGetIntegerv(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glGetIntegerv(arg0, arg1);
	}

	@Override
	public void glReleaseShaderCompiler() {
		org.lwjgl.opengles.GLES20.glReleaseShaderCompiler();
	}

	@Override
	public void nglGetVertexAttribfv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetVertexAttribfv(arg0, arg1, arg2);
	}

	@Override
	public void glTexParameterfv(int arg0, int arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public void glTexParameterfv(int arg0, int arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public int glCheckFramebufferStatus(int arg0) {
		return org.lwjgl.opengles.GLES20.glCheckFramebufferStatus(arg0);
	}

	@Override
	public void glBindFramebuffer(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBindFramebuffer(arg0, arg1);
	}

	@Override
	public void glGetUniformiv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetUniformiv(arg0, arg1, arg2);
	}

	@Override
	public void glGetUniformiv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetUniformiv(arg0, arg1, arg2);
	}

	@Override
	public boolean glIsShader(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsShader(arg0);
	}

	@Override
	public void nglGetTexParameteriv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public String glGetShaderInfoLog_String(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetShaderInfoLog(arg0);
	}

	@Override
	public void glGetShaderInfoLog(int arg0, IntBuffer arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderInfoLog(arg0, arg1, arg2);
	}

	@Override
	public void glGetShaderInfoLog(int arg0, int[] arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderInfoLog(arg0, arg1, arg2);
	}

	@Override
	public String glGetShaderInfoLog_String(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetShaderInfoLog(arg0, arg1);
	}

	@Override
	public void glDepthFunc(int arg0) {
		org.lwjgl.opengles.GLES20.glDepthFunc(arg0);
	}

	@Override
	public void glUniform3fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform3fv(arg0, arg1);
	}

	@Override
	public void glUniform3fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform3fv(arg0, arg1);
	}

	@Override
	public void glVertexAttrib3fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib3fv(arg0, arg1);
	}

	@Override
	public void glVertexAttrib3fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib3fv(arg0, arg1);
	}

	@Override
	public void glStencilMask(int arg0) {
		org.lwjgl.opengles.GLES20.glStencilMask(arg0);
	}

	@Override
	public int glGetInteger(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetInteger(arg0);
	}

	@Override
	public void glGetVertexAttribPointerv(int arg0, int arg1, PointerBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetVertexAttribPointerv(arg0, arg1, arg2);
	}

	@Override
	public void glBlendEquationSeparate(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glBlendEquationSeparate(arg0, arg1);
	}

	@Override
	public void glCopyTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		org.lwjgl.opengles.GLES20.glCopyTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void glDeleteTextures(int[] arg0) {
		org.lwjgl.opengles.GLES20.glDeleteTextures(arg0);
	}

	@Override
	public void glDeleteTextures(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteTextures(arg0);
	}

	@Override
	public void glDeleteTextures(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glDeleteTextures(arg0);
	}

	@Override
	public void glGetUniformfv(int arg0, int arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glGetUniformfv(arg0, arg1, arg2);
	}

	@Override
	public void glGetUniformfv(int arg0, int arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetUniformfv(arg0, arg1, arg2);
	}

	@Override
	public void nglVertexAttrib3fv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglVertexAttrib3fv(arg0, arg1);
	}

	@Override
	public void nglGetFloatv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGetFloatv(arg0, arg1);
	}

	@Override
	public String glGetString(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetString(arg0);
	}

	@Override
	public void glRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glRenderbufferStorage(arg0, arg1, arg2, arg3);
	}

	@Override
	public float glGetFloat(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetFloat(arg0);
	}

	@Override
	public void nglUniform3fv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform3fv(arg0, arg1, arg2);
	}

	@Override
	public void glGenBuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glGenBuffers(arg0);
	}

	@Override
	public int glGenBuffers() {
		return org.lwjgl.opengles.GLES20.glGenBuffers();
	}

	@Override
	public void glGenBuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glGenBuffers(arg0);
	}

	@Override
	public void nglDeleteBuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglDeleteBuffers(arg0, arg1);
	}

	@Override
	public void nglUniform3iv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform3iv(arg0, arg1, arg2);
	}

	@Override
	public void nglGenRenderbuffers(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGenRenderbuffers(arg0, arg1);
	}

	@Override
	public long nglGetString(int arg0) {
		return org.lwjgl.opengles.GLES20.nglGetString(arg0);
	}

	@Override
	public void nglVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, long arg5) {
		org.lwjgl.opengles.GLES20.nglVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public int glGetError() {
		return org.lwjgl.opengles.GLES20.glGetError();
	}

	@Override
	public void glScissor(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glScissor(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglGetBooleanv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglGetBooleanv(arg0, arg1);
	}

	@Override
	public void nglShaderBinary(int arg0, long arg1, int arg2, long arg3, int arg4) {
		org.lwjgl.opengles.GLES20.nglShaderBinary(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void glGetRenderbufferParameteriv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetRenderbufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glGetRenderbufferParameteriv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetRenderbufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glAttachShader(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glAttachShader(arg0, arg1);
	}

	@Override
	public void nglGetRenderbufferParameteriv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetRenderbufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void nglGetShaderiv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetShaderiv(arg0, arg1, arg2);
	}

	@Override
	public int glGetUniformLocation(int arg0, CharSequence arg1) {
		return org.lwjgl.opengles.GLES20.glGetUniformLocation(arg0, arg1);
	}

	@Override
	public int glGetUniformLocation(int arg0, ByteBuffer arg1) {
		return org.lwjgl.opengles.GLES20.glGetUniformLocation(arg0, arg1);
	}

	@Override
	public void glGetTexParameteriv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glGetTexParameteriv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetTexParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glUniform2f(int arg0, float arg1, float arg2) {
		org.lwjgl.opengles.GLES20.glUniform2f(arg0, arg1, arg2);
	}

	@Override
	public void glUniform2i(int arg0, int arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glUniform2i(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, short[] arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, ShortBuffer arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public void glBufferSubData(int arg0, long arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glBufferSubData(arg0, arg1, arg2);
	}

	@Override
	public boolean glIsEnabled(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsEnabled(arg0);
	}

	@Override
	public void glUniform3f(int arg0, float arg1, float arg2, float arg3) {
		org.lwjgl.opengles.GLES20.glUniform3f(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glUniform2fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform2fv(arg0, arg1);
	}

	@Override
	public void glUniform2fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform2fv(arg0, arg1);
	}

	@Override
	public void glUniform3i(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glUniform3i(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glClearDepthf(float arg0) {
		org.lwjgl.opengles.GLES20.glClearDepthf(arg0);
	}

	@Override
	public void glDisableVertexAttribArray(int arg0) {
		org.lwjgl.opengles.GLES20.glDisableVertexAttribArray(arg0);
	}

	@Override
	public void glUniform2iv(int arg0, IntBuffer arg1) {
		org.lwjgl.opengles.GLES20.glUniform2iv(arg0, arg1);
	}

	@Override
	public void glUniform2iv(int arg0, int[] arg1) {
		org.lwjgl.opengles.GLES20.glUniform2iv(arg0, arg1);
	}

	@Override
	public void glGetTexParameterfv(int arg0, int arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public void glGetTexParameterfv(int arg0, int arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glGetTexParameterfv(arg0, arg1, arg2);
	}

	@Override
	public void glGetBooleanv(int arg0, ByteBuffer arg1) {
		org.lwjgl.opengles.GLES20.glGetBooleanv(arg0, arg1);
	}

	@Override
	public void glUniform1f(int arg0, float arg1) {
		org.lwjgl.opengles.GLES20.glUniform1f(arg0, arg1);
	}

	@Override
	public void glUniform1i(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glUniform1i(arg0, arg1);
	}

	@Override
	public void nglGetBufferParameteriv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetBufferParameteriv(arg0, arg1, arg2);
	}

	@Override
	public void glGenerateMipmap(int arg0) {
		org.lwjgl.opengles.GLES20.glGenerateMipmap(arg0);
	}

	@Override
	public void glBlendEquation(int arg0) {
		org.lwjgl.opengles.GLES20.glBlendEquation(arg0);
	}

	@Override
	public void glClearColor(float arg0, float arg1, float arg2, float arg3) {
		org.lwjgl.opengles.GLES20.glClearColor(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glStencilFunc(int arg0, int arg1, int arg2) {
		org.lwjgl.opengles.GLES20.glStencilFunc(arg0, arg1, arg2);
	}

	@Override
	public void glVertexAttrib2fv(int arg0, FloatBuffer arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib2fv(arg0, arg1);
	}

	@Override
	public void glVertexAttrib2fv(int arg0, float[] arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib2fv(arg0, arg1);
	}

	@Override
	public void nglUniformMatrix2fv(int arg0, int arg1, boolean arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglUniformMatrix2fv(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglVertexAttrib2fv(int arg0, long arg1) {
		org.lwjgl.opengles.GLES20.nglVertexAttrib2fv(arg0, arg1);
	}

	@Override
	public int glGetAttribLocation(int arg0, ByteBuffer arg1) {
		return org.lwjgl.opengles.GLES20.glGetAttribLocation(arg0, arg1);
	}

	@Override
	public int glGetAttribLocation(int arg0, CharSequence arg1) {
		return org.lwjgl.opengles.GLES20.glGetAttribLocation(arg0, arg1);
	}

	@Override
	public int glCreateShader(int arg0) {
		return org.lwjgl.opengles.GLES20.glCreateShader(arg0);
	}

	@Override
	public void nglGetActiveAttrib(int arg0, int arg1, int arg2, long arg3, long arg4, long arg5, long arg6) {
		org.lwjgl.opengles.GLES20.nglGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public String glGetActiveAttrib_String(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3) {
		return org.lwjgl.opengles.GLES20.glGetActiveAttrib(arg0, arg1, arg2, arg3);
	}

	@Override
	public String glGetActiveAttrib_String(int arg0, int arg1, int arg2, IntBuffer arg3, IntBuffer arg4) {
		return org.lwjgl.opengles.GLES20.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void glGetActiveAttrib(int arg0, int arg1, int[] arg2, int[] arg3, int[] arg4, ByteBuffer arg5) {
		org.lwjgl.opengles.GLES20.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glGetActiveAttrib(int arg0, int arg1, IntBuffer arg2, IntBuffer arg3, IntBuffer arg4, ByteBuffer arg5) {
		org.lwjgl.opengles.GLES20.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void glUniformMatrix2fv(int arg0, boolean arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix2fv(arg0, arg1, arg2);
	}

	@Override
	public void glUniformMatrix2fv(int arg0, boolean arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glUniformMatrix2fv(arg0, arg1, arg2);
	}

	@Override
	public void glShaderSource(int arg0, PointerBuffer arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glShaderSource(arg0, arg1, arg2);
	}

	@Override
	public void glShaderSource(int arg0, CharSequence[] arg1) {
		org.lwjgl.opengles.GLES20.glShaderSource(arg0, arg1);
	}

	@Override
	public void glShaderSource(int arg0, PointerBuffer arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glShaderSource(arg0, arg1, arg2);
	}

	@Override
	public void glShaderSource(int arg0, CharSequence arg1) {
		org.lwjgl.opengles.GLES20.glShaderSource(arg0, arg1);
	}

	@Override
	public void nglUniform4fv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform4fv(arg0, arg1, arg2);
	}

	@Override
	public void glVertexAttrib4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
		org.lwjgl.opengles.GLES20.glVertexAttrib4f(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void nglGetProgramiv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglGetProgramiv(arg0, arg1, arg2);
	}

	@Override
	public void glBlendColor(float arg0, float arg1, float arg2, float arg3) {
		org.lwjgl.opengles.GLES20.glBlendColor(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglUniform4iv(int arg0, int arg1, long arg2) {
		org.lwjgl.opengles.GLES20.nglUniform4iv(arg0, arg1, arg2);
	}

	@Override
	public void nglBufferSubData(int arg0, long arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglBufferSubData(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glGetVertexAttribfv(int arg0, int arg1, FloatBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetVertexAttribfv(arg0, arg1, arg2);
	}

	@Override
	public void glGetVertexAttribfv(int arg0, int arg1, float[] arg2) {
		org.lwjgl.opengles.GLES20.glGetVertexAttribfv(arg0, arg1, arg2);
	}

	@Override
	public void nglReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
		org.lwjgl.opengles.GLES20.nglReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public boolean glIsFramebuffer(int arg0) {
		return org.lwjgl.opengles.GLES20.glIsFramebuffer(arg0);
	}

	@Override
	public void glGetShaderSource(int arg0, IntBuffer arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderSource(arg0, arg1, arg2);
	}

	@Override
	public void glGetShaderSource(int arg0, int[] arg1, ByteBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetShaderSource(arg0, arg1, arg2);
	}

	@Override
	public String glGetShaderSource_String(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetShaderSource(arg0, arg1);
	}

	@Override
	public String glGetShaderSource_String(int arg0) {
		return org.lwjgl.opengles.GLES20.glGetShaderSource(arg0);
	}

	@Override
	public void glGetVertexAttribiv(int arg0, int arg1, IntBuffer arg2) {
		org.lwjgl.opengles.GLES20.glGetVertexAttribiv(arg0, arg1, arg2);
	}

	@Override
	public void glGetVertexAttribiv(int arg0, int arg1, int[] arg2) {
		org.lwjgl.opengles.GLES20.glGetVertexAttribiv(arg0, arg1, arg2);
	}

	@Override
	public void glStencilOpSeparate(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glStencilOpSeparate(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ByteBuffer arg6) {
		org.lwjgl.opengles.GLES20.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	@Override
	public void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
			long arg7) {
		org.lwjgl.opengles.GLES20.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void glDeleteBuffers(int[] arg0) {
		org.lwjgl.opengles.GLES20.glDeleteBuffers(arg0);
	}

	@Override
	public void glDeleteBuffers(int arg0) {
		org.lwjgl.opengles.GLES20.glDeleteBuffers(arg0);
	}

	@Override
	public void glDeleteBuffers(IntBuffer arg0) {
		org.lwjgl.opengles.GLES20.glDeleteBuffers(arg0);
	}

	@Override
	public void glStencilFuncSeparate(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glStencilFuncSeparate(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glPixelStorei(int arg0, int arg1) {
		org.lwjgl.opengles.GLES20.glPixelStorei(arg0, arg1);
	}

	@Override
	public void glCopyTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		org.lwjgl.opengles.GLES20.glCopyTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void glVertexAttrib1f(int arg0, float arg1) {
		org.lwjgl.opengles.GLES20.glVertexAttrib1f(arg0, arg1);
	}

	@Override
	public void nglBufferData(int arg0, long arg1, long arg2, int arg3) {
		org.lwjgl.opengles.GLES20.nglBufferData(arg0, arg1, arg2, arg3);
	}

	@Override
	public void nglGetShaderPrecisionFormat(int arg0, int arg1, long arg2, long arg3) {
		org.lwjgl.opengles.GLES20.nglGetShaderPrecisionFormat(arg0, arg1, arg2, arg3);
	}

	@Override
	public int glGetBufferParameteri(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetBufferParameteri(arg0, arg1);
	}

	@Override
	public void glVertexAttrib3f(int arg0, float arg1, float arg2, float arg3) {
		org.lwjgl.opengles.GLES20.glVertexAttrib3f(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glVertexAttrib2f(int arg0, float arg1, float arg2) {
		org.lwjgl.opengles.GLES20.glVertexAttrib2f(arg0, arg1, arg2);
	}

	@Override
	public float glGetTexParameterf(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetTexParameterf(arg0, arg1);
	}

	@Override
	public int glGetTexParameteri(int arg0, int arg1) {
		return org.lwjgl.opengles.GLES20.glGetTexParameteri(arg0, arg1);
	}

	@Override
	public void nglTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
			long arg8) {
		org.lwjgl.opengles.GLES20.nglTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Override
	public void glFinish() {
		org.lwjgl.opengles.GLES20.glFinish();
	}

	@Override
	public void glFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) {
		org.lwjgl.opengles.GLES20.glFramebufferRenderbuffer(arg0, arg1, arg2, arg3);
	}

	@Override
	public void glActiveTexture(int arg0) {
		org.lwjgl.opengles.GLES20.glActiveTexture(arg0);
	}

	@Override
	public void glLinkProgram(int arg0) {
		org.lwjgl.opengles.GLES20.glLinkProgram(arg0);
	}

	@Override
	public boolean checkError(String message) {
		GameEngineUtils.checkGlESError(message);
		return true;
	}

	@Override
	public boolean isGLES() {
		return true;
	}

	@Override
	public boolean isGL() {
		return false;
	}
}
