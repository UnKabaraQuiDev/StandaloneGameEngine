package lu.kbra.standalone.gameengine.utils.gl.wrapper;

public class GL_W {

	public static GL_W_Call WRAPPER;

	public static int GL_SRC1_COLOR;
	public static int GL_ONE_MINUS_SRC1_COLOR;
	public static int GL_ONE_MINUS_SRC1_ALPHA;
	public static int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS;
	public static int GL_ANY_SAMPLES_PASSED;
	public static int GL_SAMPLER_BINDING;
	public static int GL_RGB10_A2UI;
	public static int GL_TEXTURE_SWIZZLE_R;
	public static int GL_TEXTURE_SWIZZLE_G;
	public static int GL_TEXTURE_SWIZZLE_B;
	public static int GL_TEXTURE_SWIZZLE_A;
	public static int GL_TEXTURE_SWIZZLE_RGBA;
	public static int GL_TIME_ELAPSED;
	public static int GL_TIMESTAMP;
	public static int GL_VERTEX_ATTRIB_ARRAY_DIVISOR;
	public static int GL_INT_2_10_10_10_REV;
	public static int GL_CONTEXT_PROFILE_MASK;
	public static int GL_CONTEXT_CORE_PROFILE_BIT;
	public static int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT;
	public static int GL_MAX_VERTEX_OUTPUT_COMPONENTS;
	public static int GL_MAX_GEOMETRY_INPUT_COMPONENTS;
	public static int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS;
	public static int GL_MAX_FRAGMENT_INPUT_COMPONENTS;
	public static int GL_FIRST_VERTEX_CONVENTION;
	public static int GL_LAST_VERTEX_CONVENTION;
	public static int GL_PROVOKING_VERTEX;
	public static int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION;
	public static int GL_TEXTURE_CUBE_MAP_SEAMLESS;
	public static int GL_SAMPLE_POSITION;
	public static int GL_SAMPLE_MASK;
	public static int GL_SAMPLE_MASK_VALUE;
	public static int GL_TEXTURE_2D_MULTISAMPLE;
	public static int GL_PROXY_TEXTURE_2D_MULTISAMPLE;
	public static int GL_TEXTURE_2D_MULTISAMPLE_ARRAY;
	public static int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY;
	public static int GL_MAX_SAMPLE_MASK_WORDS;
	public static int GL_MAX_COLOR_TEXTURE_SAMPLES;
	public static int GL_MAX_DEPTH_TEXTURE_SAMPLES;
	public static int GL_MAX_INTEGER_SAMPLES;
	public static int GL_TEXTURE_BINDING_2D_MULTISAMPLE;
	public static int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY;
	public static int GL_TEXTURE_SAMPLES;
	public static int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS;
	public static int GL_SAMPLER_2D_MULTISAMPLE;
	public static int GL_INT_SAMPLER_2D_MULTISAMPLE;
	public static int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE;
	public static int GL_SAMPLER_2D_MULTISAMPLE_ARRAY;
	public static int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY;
	public static int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY;
	public static int GL_DEPTH_CLAMP;
	public static int GL_GEOMETRY_SHADER;
	public static int GL_GEOMETRY_VERTICES_OUT;
	public static int GL_GEOMETRY_INPUT_TYPE;
	public static int GL_GEOMETRY_OUTPUT_TYPE;
	public static int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS;
	public static int GL_MAX_GEOMETRY_OUTPUT_VERTICES;
	public static int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS;
	public static int GL_LINES_ADJACENCY;
	public static int GL_LINE_STRIP_ADJACENCY;
	public static int GL_TRIANGLES_ADJACENCY;
	public static int GL_TRIANGLE_STRIP_ADJACENCY;
	public static int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS;
	public static int GL_FRAMEBUFFER_ATTACHMENT_LAYERED;
	public static int GL_PROGRAM_POINT_SIZE;
	public static int GL_MAX_SERVER_WAIT_TIMEOUT;
	public static int GL_OBJECT_TYPE;
	public static int GL_SYNC_CONDITION;
	public static int GL_SYNC_STATUS;
	public static int GL_SYNC_FLAGS;
	public static int GL_SYNC_FENCE;
	public static int GL_SYNC_GPU_COMMANDS_COMPLETE;
	public static int GL_UNSIGNALED;
	public static int GL_SIGNALED;
	public static int GL_SYNC_FLUSH_COMMANDS_BIT;
	public static int GL_ALREADY_SIGNALED;
	public static int GL_TIMEOUT_EXPIRED;
	public static int GL_CONDITION_SATISFIED;
	public static int GL_WAIT_FAILED;
	public static int GL_R8_SNORM;
	public static int GL_RG8_SNORM;
	public static int GL_RGB8_SNORM;
	public static int GL_RGBA8_SNORM;
	public static int GL_R16_SNORM;
	public static int GL_RG16_SNORM;
	public static int GL_RGB16_SNORM;
	public static int GL_RGBA16_SNORM;
	public static int GL_SIGNED_NORMALIZED;
	public static int GL_SAMPLER_BUFFER;
	public static int GL_INT_SAMPLER_2D_RECT;
	public static int GL_INT_SAMPLER_BUFFER;
	public static int GL_UNSIGNED_INT_SAMPLER_2D_RECT;
	public static int GL_UNSIGNED_INT_SAMPLER_BUFFER;
	public static int GL_COPY_READ_BUFFER;
	public static int GL_COPY_WRITE_BUFFER;
	public static int GL_PRIMITIVE_RESTART;
	public static int GL_PRIMITIVE_RESTART_INDEX;
	public static int GL_TEXTURE_BUFFER;
	public static int GL_MAX_TEXTURE_BUFFER_SIZE;
	public static int GL_TEXTURE_BINDING_BUFFER;
	public static int GL_TEXTURE_BUFFER_DATA_STORE_BINDING;
	public static int GL_TEXTURE_RECTANGLE;
	public static int GL_TEXTURE_BINDING_RECTANGLE;
	public static int GL_PROXY_TEXTURE_RECTANGLE;
	public static int GL_MAX_RECTANGLE_TEXTURE_SIZE;
	public static int GL_SAMPLER_2D_RECT;
	public static int GL_SAMPLER_2D_RECT_SHADOW;
	public static int GL_UNIFORM_BUFFER;
	public static int GL_UNIFORM_BUFFER_BINDING;
	public static int GL_UNIFORM_BUFFER_START;
	public static int GL_UNIFORM_BUFFER_SIZE;
	public static int GL_MAX_VERTEX_UNIFORM_BLOCKS;
	public static int GL_MAX_GEOMETRY_UNIFORM_BLOCKS;
	public static int GL_MAX_FRAGMENT_UNIFORM_BLOCKS;
	public static int GL_MAX_COMBINED_UNIFORM_BLOCKS;
	public static int GL_MAX_UNIFORM_BUFFER_BINDINGS;
	public static int GL_MAX_UNIFORM_BLOCK_SIZE;
	public static int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS;
	public static int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS;
	public static int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS;
	public static int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT;
	public static int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH;
	public static int GL_ACTIVE_UNIFORM_BLOCKS;
	public static int GL_UNIFORM_TYPE;
	public static int GL_UNIFORM_SIZE;
	public static int GL_UNIFORM_NAME_LENGTH;
	public static int GL_UNIFORM_BLOCK_INDEX;
	public static int GL_UNIFORM_OFFSET;
	public static int GL_UNIFORM_ARRAY_STRIDE;
	public static int GL_UNIFORM_MATRIX_STRIDE;
	public static int GL_UNIFORM_IS_ROW_MAJOR;
	public static int GL_UNIFORM_BLOCK_BINDING;
	public static int GL_UNIFORM_BLOCK_DATA_SIZE;
	public static int GL_UNIFORM_BLOCK_NAME_LENGTH;
	public static int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS;
	public static int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER;
	public static int GL_INVALID_INDEX;
	public static int GL_MAJOR_VERSION;
	public static int GL_MINOR_VERSION;
	public static int GL_NUM_EXTENSIONS;
	public static int GL_CONTEXT_FLAGS;
	public static int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT;
	public static int GL_COMPARE_REF_TO_TEXTURE;
	public static int GL_CLIP_DISTANCE0;
	public static int GL_CLIP_DISTANCE1;
	public static int GL_CLIP_DISTANCE2;
	public static int GL_CLIP_DISTANCE3;
	public static int GL_CLIP_DISTANCE4;
	public static int GL_CLIP_DISTANCE5;
	public static int GL_CLIP_DISTANCE6;
	public static int GL_CLIP_DISTANCE7;
	public static int GL_MAX_CLIP_DISTANCES;
	public static int GL_MAX_VARYING_COMPONENTS;
	public static int GL_VERTEX_ATTRIB_ARRAY_INTEGER;
	public static int GL_SAMPLER_1D_ARRAY;
	public static int GL_SAMPLER_2D_ARRAY;
	public static int GL_SAMPLER_1D_ARRAY_SHADOW;
	public static int GL_SAMPLER_2D_ARRAY_SHADOW;
	public static int GL_SAMPLER_CUBE_SHADOW;
	public static int GL_UNSIGNED_INT_VEC2;
	public static int GL_UNSIGNED_INT_VEC3;
	public static int GL_UNSIGNED_INT_VEC4;
	public static int GL_INT_SAMPLER_1D;
	public static int GL_INT_SAMPLER_2D;
	public static int GL_INT_SAMPLER_3D;
	public static int GL_INT_SAMPLER_CUBE;
	public static int GL_INT_SAMPLER_1D_ARRAY;
	public static int GL_INT_SAMPLER_2D_ARRAY;
	public static int GL_UNSIGNED_INT_SAMPLER_1D;
	public static int GL_UNSIGNED_INT_SAMPLER_2D;
	public static int GL_UNSIGNED_INT_SAMPLER_3D;
	public static int GL_UNSIGNED_INT_SAMPLER_CUBE;
	public static int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY;
	public static int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY;
	public static int GL_MIN_PROGRAM_TEXEL_OFFSET;
	public static int GL_MAX_PROGRAM_TEXEL_OFFSET;
	public static int GL_QUERY_WAIT;
	public static int GL_QUERY_NO_WAIT;
	public static int GL_QUERY_BY_REGION_WAIT;
	public static int GL_QUERY_BY_REGION_NO_WAIT;
	public static int GL_MAP_READ_BIT;
	public static int GL_MAP_WRITE_BIT;
	public static int GL_MAP_INVALIDATE_RANGE_BIT;
	public static int GL_MAP_INVALIDATE_BUFFER_BIT;
	public static int GL_MAP_FLUSH_EXPLICIT_BIT;
	public static int GL_MAP_UNSYNCHRONIZED_BIT;
	public static int GL_BUFFER_ACCESS_FLAGS;
	public static int GL_BUFFER_MAP_LENGTH;
	public static int GL_BUFFER_MAP_OFFSET;
	public static int GL_CLAMP_VERTEX_COLOR;
	public static int GL_CLAMP_FRAGMENT_COLOR;
	public static int GL_CLAMP_READ_COLOR;
	public static int GL_FIXED_ONLY;
	public static int GL_DEPTH_COMPONENT32F;
	public static int GL_DEPTH32F_STENCIL8;
	public static int GL_FLOAT_32_UNSIGNED_INT_24_8_REV;
	public static int GL_TEXTURE_RED_TYPE;
	public static int GL_TEXTURE_GREEN_TYPE;
	public static int GL_TEXTURE_BLUE_TYPE;
	public static int GL_TEXTURE_ALPHA_TYPE;
	public static int GL_TEXTURE_LUMINANCE_TYPE;
	public static int GL_TEXTURE_INTENSITY_TYPE;
	public static int GL_TEXTURE_DEPTH_TYPE;
	public static int GL_UNSIGNED_NORMALIZED;
	public static int GL_RGBA32F;
	public static int GL_RGB32F;
	public static int GL_RGBA16F;
	public static int GL_RGB16F;
	public static int GL_R11F_G11F_B10F;
	public static int GL_UNSIGNED_INT_10F_11F_11F_REV;
	public static int GL_RGB9_E5;
	public static int GL_UNSIGNED_INT_5_9_9_9_REV;
	public static int GL_TEXTURE_SHARED_SIZE;
	public static int GL_FRAMEBUFFER;
	public static int GL_READ_FRAMEBUFFER;
	public static int GL_DRAW_FRAMEBUFFER;
	public static int GL_RENDERBUFFER;
	public static int GL_STENCIL_INDEX1;
	public static int GL_STENCIL_INDEX4;
	public static int GL_STENCIL_INDEX8;
	public static int GL_STENCIL_INDEX16;
	public static int GL_RENDERBUFFER_WIDTH;
	public static int GL_RENDERBUFFER_HEIGHT;
	public static int GL_RENDERBUFFER_INTERNAL_FORMAT;
	public static int GL_RENDERBUFFER_RED_SIZE;
	public static int GL_RENDERBUFFER_GREEN_SIZE;
	public static int GL_RENDERBUFFER_BLUE_SIZE;
	public static int GL_RENDERBUFFER_ALPHA_SIZE;
	public static int GL_RENDERBUFFER_DEPTH_SIZE;
	public static int GL_RENDERBUFFER_STENCIL_SIZE;
	public static int GL_RENDERBUFFER_SAMPLES;
	public static int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
	public static int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
	public static int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER;
	public static int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING;
	public static int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE;
	public static int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE;
	public static int GL_FRAMEBUFFER_DEFAULT;
	public static int GL_INDEX;
	public static int GL_COLOR_ATTACHMENT0;
	public static int GL_COLOR_ATTACHMENT1;
	public static int GL_COLOR_ATTACHMENT2;
	public static int GL_COLOR_ATTACHMENT3;
	public static int GL_COLOR_ATTACHMENT4;
	public static int GL_COLOR_ATTACHMENT5;
	public static int GL_COLOR_ATTACHMENT6;
	public static int GL_COLOR_ATTACHMENT7;
	public static int GL_COLOR_ATTACHMENT8;
	public static int GL_COLOR_ATTACHMENT9;
	public static int GL_COLOR_ATTACHMENT10;
	public static int GL_COLOR_ATTACHMENT11;
	public static int GL_COLOR_ATTACHMENT12;
	public static int GL_COLOR_ATTACHMENT13;
	public static int GL_COLOR_ATTACHMENT14;
	public static int GL_COLOR_ATTACHMENT15;
	public static int GL_COLOR_ATTACHMENT16;
	public static int GL_COLOR_ATTACHMENT17;
	public static int GL_COLOR_ATTACHMENT18;
	public static int GL_COLOR_ATTACHMENT19;
	public static int GL_COLOR_ATTACHMENT20;
	public static int GL_COLOR_ATTACHMENT21;
	public static int GL_COLOR_ATTACHMENT22;
	public static int GL_COLOR_ATTACHMENT23;
	public static int GL_COLOR_ATTACHMENT24;
	public static int GL_COLOR_ATTACHMENT25;
	public static int GL_COLOR_ATTACHMENT26;
	public static int GL_COLOR_ATTACHMENT27;
	public static int GL_COLOR_ATTACHMENT28;
	public static int GL_COLOR_ATTACHMENT29;
	public static int GL_COLOR_ATTACHMENT30;
	public static int GL_COLOR_ATTACHMENT31;
	public static int GL_DEPTH_ATTACHMENT;
	public static int GL_STENCIL_ATTACHMENT;
	public static int GL_DEPTH_STENCIL_ATTACHMENT;
	public static int GL_MAX_SAMPLES;
	public static int GL_FRAMEBUFFER_COMPLETE;
	public static int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
	public static int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
	public static int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER;
	public static int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER;
	public static int GL_FRAMEBUFFER_UNSUPPORTED;
	public static int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE;
	public static int GL_FRAMEBUFFER_UNDEFINED;
	public static int GL_FRAMEBUFFER_BINDING;
	public static int GL_DRAW_FRAMEBUFFER_BINDING;
	public static int GL_READ_FRAMEBUFFER_BINDING;
	public static int GL_RENDERBUFFER_BINDING;
	public static int GL_MAX_COLOR_ATTACHMENTS;
	public static int GL_MAX_RENDERBUFFER_SIZE;
	public static int GL_INVALID_FRAMEBUFFER_OPERATION;
	public static int GL_DEPTH_STENCIL;
	public static int GL_UNSIGNED_INT_24_8;
	public static int GL_DEPTH24_STENCIL8;
	public static int GL_TEXTURE_STENCIL_SIZE;
	public static int GL_HALF_FLOAT;
	public static int GL_RGBA32UI;
	public static int GL_RGB32UI;
	public static int GL_RGBA16UI;
	public static int GL_RGB16UI;
	public static int GL_RGBA8UI;
	public static int GL_RGB8UI;
	public static int GL_RGBA32I;
	public static int GL_RGB32I;
	public static int GL_RGBA16I;
	public static int GL_RGB16I;
	public static int GL_RGBA8I;
	public static int GL_RGB8I;
	public static int GL_RED_INTEGER;
	public static int GL_GREEN_INTEGER;
	public static int GL_BLUE_INTEGER;
	public static int GL_ALPHA_INTEGER;
	public static int GL_RGB_INTEGER;
	public static int GL_RGBA_INTEGER;
	public static int GL_BGR_INTEGER;
	public static int GL_BGRA_INTEGER;
	public static int GL_TEXTURE_1D_ARRAY;
	public static int GL_TEXTURE_2D_ARRAY;
	public static int GL_PROXY_TEXTURE_2D_ARRAY;
	public static int GL_PROXY_TEXTURE_1D_ARRAY;
	public static int GL_TEXTURE_BINDING_1D_ARRAY;
	public static int GL_TEXTURE_BINDING_2D_ARRAY;
	public static int GL_MAX_ARRAY_TEXTURE_LAYERS;
	public static int GL_COMPRESSED_RED_RGTC1;
	public static int GL_COMPRESSED_SIGNED_RED_RGTC1;
	public static int GL_COMPRESSED_RG_RGTC2;
	public static int GL_COMPRESSED_SIGNED_RG_RGTC2;
	public static int GL_R8;
	public static int GL_R16;
	public static int GL_RG8;
	public static int GL_RG16;
	public static int GL_R16F;
	public static int GL_R32F;
	public static int GL_RG16F;
	public static int GL_RG32F;
	public static int GL_R8I;
	public static int GL_R8UI;
	public static int GL_R16I;
	public static int GL_R16UI;
	public static int GL_R32I;
	public static int GL_R32UI;
	public static int GL_RG8I;
	public static int GL_RG8UI;
	public static int GL_RG16I;
	public static int GL_RG16UI;
	public static int GL_RG32I;
	public static int GL_RG32UI;
	public static int GL_RG;
	public static int GL_COMPRESSED_RED;
	public static int GL_COMPRESSED_RG;
	public static int GL_RG_INTEGER;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_START;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING;
	public static int GL_INTERLEAVED_ATTRIBS;
	public static int GL_SEPARATE_ATTRIBS;
	public static int GL_PRIMITIVES_GENERATED;
	public static int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN;
	public static int GL_RASTERIZER_DISCARD;
	public static int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS;
	public static int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS;
	public static int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS;
	public static int GL_TRANSFORM_FEEDBACK_VARYINGS;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_MODE;
	public static int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH;
	public static int GL_VERTEX_ARRAY_BINDING;
	public static int GL_FRAMEBUFFER_SRGB;
	public static int GL_CURRENT_RASTER_SECONDARY_COLOR;
	public static int GL_FLOAT_MAT2x3;
	public static int GL_FLOAT_MAT2x4;
	public static int GL_FLOAT_MAT3x2;
	public static int GL_FLOAT_MAT3x4;
	public static int GL_FLOAT_MAT4x2;
	public static int GL_FLOAT_MAT4x3;
	public static int GL_PIXEL_PACK_BUFFER;
	public static int GL_PIXEL_UNPACK_BUFFER;
	public static int GL_PIXEL_PACK_BUFFER_BINDING;
	public static int GL_PIXEL_UNPACK_BUFFER_BINDING;
	public static int GL_SRGB;
	public static int GL_SRGB8;
	public static int GL_SRGB_ALPHA;
	public static int GL_SRGB8_ALPHA8;
	public static int GL_SLUMINANCE_ALPHA;
	public static int GL_SLUMINANCE8_ALPHA8;
	public static int GL_SLUMINANCE;
	public static int GL_SLUMINANCE8;
	public static int GL_COMPRESSED_SRGB;
	public static int GL_COMPRESSED_SRGB_ALPHA;
	public static int GL_COMPRESSED_SLUMINANCE;
	public static int GL_COMPRESSED_SLUMINANCE_ALPHA;
	public static int GL_SHADING_LANGUAGE_VERSION;
	public static int GL_CURRENT_PROGRAM;
	public static int GL_SHADER_TYPE;
	public static int GL_DELETE_STATUS;
	public static int GL_COMPILE_STATUS;
	public static int GL_LINK_STATUS;
	public static int GL_VALIDATE_STATUS;
	public static int GL_INFO_LOG_LENGTH;
	public static int GL_ATTACHED_SHADERS;
	public static int GL_ACTIVE_UNIFORMS;
	public static int GL_ACTIVE_UNIFORM_MAX_LENGTH;
	public static int GL_ACTIVE_ATTRIBUTES;
	public static int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH;
	public static int GL_SHADER_SOURCE_LENGTH;
	public static int GL_FLOAT_VEC2;
	public static int GL_FLOAT_VEC3;
	public static int GL_FLOAT_VEC4;
	public static int GL_INT_VEC2;
	public static int GL_INT_VEC3;
	public static int GL_INT_VEC4;
	public static int GL_BOOL;
	public static int GL_BOOL_VEC2;
	public static int GL_BOOL_VEC3;
	public static int GL_BOOL_VEC4;
	public static int GL_FLOAT_MAT2;
	public static int GL_FLOAT_MAT3;
	public static int GL_FLOAT_MAT4;
	public static int GL_SAMPLER_1D;
	public static int GL_SAMPLER_2D;
	public static int GL_SAMPLER_3D;
	public static int GL_SAMPLER_CUBE;
	public static int GL_SAMPLER_1D_SHADOW;
	public static int GL_SAMPLER_2D_SHADOW;
	public static int GL_VERTEX_SHADER;
	public static int GL_MAX_VERTEX_UNIFORM_COMPONENTS;
	public static int GL_MAX_VARYING_FLOATS;
	public static int GL_MAX_VERTEX_ATTRIBS;
	public static int GL_MAX_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_TEXTURE_COORDS;
	public static int GL_VERTEX_PROGRAM_POINT_SIZE;
	public static int GL_VERTEX_PROGRAM_TWO_SIDE;
	public static int GL_VERTEX_ATTRIB_ARRAY_ENABLED;
	public static int GL_VERTEX_ATTRIB_ARRAY_SIZE;
	public static int GL_VERTEX_ATTRIB_ARRAY_STRIDE;
	public static int GL_VERTEX_ATTRIB_ARRAY_TYPE;
	public static int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
	public static int GL_CURRENT_VERTEX_ATTRIB;
	public static int GL_VERTEX_ATTRIB_ARRAY_POINTER;
	public static int GL_FRAGMENT_SHADER;
	public static int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS;
	public static int GL_FRAGMENT_SHADER_DERIVATIVE_HINT;
	public static int GL_MAX_DRAW_BUFFERS;
	public static int GL_DRAW_BUFFER0;
	public static int GL_DRAW_BUFFER1;
	public static int GL_DRAW_BUFFER2;
	public static int GL_DRAW_BUFFER3;
	public static int GL_DRAW_BUFFER4;
	public static int GL_DRAW_BUFFER5;
	public static int GL_DRAW_BUFFER6;
	public static int GL_DRAW_BUFFER7;
	public static int GL_DRAW_BUFFER8;
	public static int GL_DRAW_BUFFER9;
	public static int GL_DRAW_BUFFER10;
	public static int GL_DRAW_BUFFER11;
	public static int GL_DRAW_BUFFER12;
	public static int GL_DRAW_BUFFER13;
	public static int GL_DRAW_BUFFER14;
	public static int GL_DRAW_BUFFER15;
	public static int GL_POINT_SPRITE;
	public static int GL_COORD_REPLACE;
	public static int GL_POINT_SPRITE_COORD_ORIGIN;
	public static int GL_LOWER_LEFT;
	public static int GL_UPPER_LEFT;
	public static int GL_BLEND_EQUATION_RGB;
	public static int GL_BLEND_EQUATION_ALPHA;
	public static int GL_STENCIL_BACK_FUNC;
	public static int GL_STENCIL_BACK_FAIL;
	public static int GL_STENCIL_BACK_PASS_DEPTH_FAIL;
	public static int GL_STENCIL_BACK_PASS_DEPTH_PASS;
	public static int GL_STENCIL_BACK_REF;
	public static int GL_STENCIL_BACK_VALUE_MASK;
	public static int GL_STENCIL_BACK_WRITEMASK;
	public static int GL_FOG_COORD_SRC;
	public static int GL_FOG_COORD;
	public static int GL_CURRENT_FOG_COORD;
	public static int GL_FOG_COORD_ARRAY_TYPE;
	public static int GL_FOG_COORD_ARRAY_STRIDE;
	public static int GL_FOG_COORD_ARRAY_POINTER;
	public static int GL_FOG_COORD_ARRAY;
	public static int GL_FOG_COORD_ARRAY_BUFFER_BINDING;
	public static int GL_SRC0_RGB;
	public static int GL_SRC1_RGB;
	public static int GL_SRC2_RGB;
	public static int GL_SRC0_ALPHA;
	public static int GL_SRC1_ALPHA;
	public static int GL_SRC2_ALPHA;
	public static int GL_ARRAY_BUFFER;
	public static int GL_ELEMENT_ARRAY_BUFFER;
	public static int GL_ARRAY_BUFFER_BINDING;
	public static int GL_ELEMENT_ARRAY_BUFFER_BINDING;
	public static int GL_VERTEX_ARRAY_BUFFER_BINDING;
	public static int GL_NORMAL_ARRAY_BUFFER_BINDING;
	public static int GL_COLOR_ARRAY_BUFFER_BINDING;
	public static int GL_INDEX_ARRAY_BUFFER_BINDING;
	public static int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING;
	public static int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING;
	public static int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING;
	public static int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING;
	public static int GL_WEIGHT_ARRAY_BUFFER_BINDING;
	public static int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
	public static int GL_STREAM_DRAW;
	public static int GL_STREAM_READ;
	public static int GL_STREAM_COPY;
	public static int GL_STATIC_DRAW;
	public static int GL_STATIC_READ;
	public static int GL_STATIC_COPY;
	public static int GL_DYNAMIC_DRAW;
	public static int GL_DYNAMIC_READ;
	public static int GL_DYNAMIC_COPY;
	public static int GL_READ_ONLY;
	public static int GL_WRITE_ONLY;
	public static int GL_READ_WRITE;
	public static int GL_BUFFER_SIZE;
	public static int GL_BUFFER_USAGE;
	public static int GL_BUFFER_ACCESS;
	public static int GL_BUFFER_MAPPED;
	public static int GL_BUFFER_MAP_POINTER;
	public static int GL_SAMPLES_PASSED;
	public static int GL_QUERY_COUNTER_BITS;
	public static int GL_CURRENT_QUERY;
	public static int GL_QUERY_RESULT;
	public static int GL_QUERY_RESULT_AVAILABLE;
	public static int GL_GENERATE_MIPMAP;
	public static int GL_GENERATE_MIPMAP_HINT;
	public static int GL_CONSTANT_COLOR;
	public static int GL_ONE_MINUS_CONSTANT_COLOR;
	public static int GL_CONSTANT_ALPHA;
	public static int GL_ONE_MINUS_CONSTANT_ALPHA;
	public static int GL_FUNC_ADD;
	public static int GL_MIN;
	public static int GL_MAX;
	public static int GL_FUNC_SUBTRACT;
	public static int GL_FUNC_REVERSE_SUBTRACT;
	public static int GL_DEPTH_COMPONENT16;
	public static int GL_DEPTH_COMPONENT24;
	public static int GL_DEPTH_COMPONENT32;
	public static int GL_TEXTURE_DEPTH_SIZE;
	public static int GL_DEPTH_TEXTURE_MODE;
	public static int GL_TEXTURE_COMPARE_MODE;
	public static int GL_TEXTURE_COMPARE_FUNC;
	public static int GL_COMPARE_R_TO_TEXTURE;
	public static int GL_FOG_COORDINATE_SOURCE;
	public static int GL_FOG_COORDINATE;
	public static int GL_FRAGMENT_DEPTH;
	public static int GL_CURRENT_FOG_COORDINATE;
	public static int GL_FOG_COORDINATE_ARRAY_TYPE;
	public static int GL_FOG_COORDINATE_ARRAY_STRIDE;
	public static int GL_FOG_COORDINATE_ARRAY_POINTER;
	public static int GL_FOG_COORDINATE_ARRAY;
	public static int GL_POINT_SIZE_MIN;
	public static int GL_POINT_SIZE_MAX;
	public static int GL_POINT_FADE_THRESHOLD_SIZE;
	public static int GL_POINT_DISTANCE_ATTENUATION;
	public static int GL_COLOR_SUM;
	public static int GL_CURRENT_SECONDARY_COLOR;
	public static int GL_SECONDARY_COLOR_ARRAY_SIZE;
	public static int GL_SECONDARY_COLOR_ARRAY_TYPE;
	public static int GL_SECONDARY_COLOR_ARRAY_STRIDE;
	public static int GL_SECONDARY_COLOR_ARRAY_POINTER;
	public static int GL_SECONDARY_COLOR_ARRAY;
	public static int GL_BLEND_DST_RGB;
	public static int GL_BLEND_SRC_RGB;
	public static int GL_BLEND_DST_ALPHA;
	public static int GL_BLEND_SRC_ALPHA;
	public static int GL_INCR_WRAP;
	public static int GL_DECR_WRAP;
	public static int GL_TEXTURE_FILTER_CONTROL;
	public static int GL_TEXTURE_LOD_BIAS;
	public static int GL_MAX_TEXTURE_LOD_BIAS;
	public static int GL_MIRRORED_REPEAT;
	public static int GL_COMPRESSED_ALPHA;
	public static int GL_COMPRESSED_LUMINANCE;
	public static int GL_COMPRESSED_LUMINANCE_ALPHA;
	public static int GL_COMPRESSED_INTENSITY;
	public static int GL_COMPRESSED_RGB;
	public static int GL_COMPRESSED_RGBA;
	public static int GL_TEXTURE_COMPRESSION_HINT;
	public static int GL_TEXTURE_COMPRESSED_IMAGE_SIZE;
	public static int GL_TEXTURE_COMPRESSED;
	public static int GL_NUM_COMPRESSED_TEXTURE_FORMATS;
	public static int GL_COMPRESSED_TEXTURE_FORMATS;
	public static int GL_NORMAL_MAP;
	public static int GL_REFLECTION_MAP;
	public static int GL_TEXTURE_CUBE_MAP;
	public static int GL_TEXTURE_BINDING_CUBE_MAP;
	public static int GL_TEXTURE_CUBE_MAP_POSITIVE_X;
	public static int GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
	public static int GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
	public static int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
	public static int GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
	public static int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;
	public static int GL_PROXY_TEXTURE_CUBE_MAP;
	public static int GL_MAX_CUBE_MAP_TEXTURE_SIZE;
	public static int GL_MULTISAMPLE;
	public static int GL_SAMPLE_ALPHA_TO_COVERAGE;
	public static int GL_SAMPLE_ALPHA_TO_ONE;
	public static int GL_SAMPLE_COVERAGE;
	public static int GL_MULTISAMPLE_BIT;
	public static int GL_SAMPLE_BUFFERS;
	public static int GL_SAMPLES;
	public static int GL_SAMPLE_COVERAGE_VALUE;
	public static int GL_SAMPLE_COVERAGE_INVERT;
	public static int GL_TEXTURE0;
	public static int GL_TEXTURE1;
	public static int GL_TEXTURE2;
	public static int GL_TEXTURE3;
	public static int GL_TEXTURE4;
	public static int GL_TEXTURE5;
	public static int GL_TEXTURE6;
	public static int GL_TEXTURE7;
	public static int GL_TEXTURE8;
	public static int GL_TEXTURE9;
	public static int GL_TEXTURE10;
	public static int GL_TEXTURE11;
	public static int GL_TEXTURE12;
	public static int GL_TEXTURE13;
	public static int GL_TEXTURE14;
	public static int GL_TEXTURE15;
	public static int GL_TEXTURE16;
	public static int GL_TEXTURE17;
	public static int GL_TEXTURE18;
	public static int GL_TEXTURE19;
	public static int GL_TEXTURE20;
	public static int GL_TEXTURE21;
	public static int GL_TEXTURE22;
	public static int GL_TEXTURE23;
	public static int GL_TEXTURE24;
	public static int GL_TEXTURE25;
	public static int GL_TEXTURE26;
	public static int GL_TEXTURE27;
	public static int GL_TEXTURE28;
	public static int GL_TEXTURE29;
	public static int GL_TEXTURE30;
	public static int GL_TEXTURE31;
	public static int GL_ACTIVE_TEXTURE;
	public static int GL_CLIENT_ACTIVE_TEXTURE;
	public static int GL_MAX_TEXTURE_UNITS;
	public static int GL_COMBINE;
	public static int GL_COMBINE_RGB;
	public static int GL_COMBINE_ALPHA;
	public static int GL_SOURCE0_RGB;
	public static int GL_SOURCE1_RGB;
	public static int GL_SOURCE2_RGB;
	public static int GL_SOURCE0_ALPHA;
	public static int GL_SOURCE1_ALPHA;
	public static int GL_SOURCE2_ALPHA;
	public static int GL_OPERAND0_RGB;
	public static int GL_OPERAND1_RGB;
	public static int GL_OPERAND2_RGB;
	public static int GL_OPERAND0_ALPHA;
	public static int GL_OPERAND1_ALPHA;
	public static int GL_OPERAND2_ALPHA;
	public static int GL_RGB_SCALE;
	public static int GL_ADD_SIGNED;
	public static int GL_INTERPOLATE;
	public static int GL_SUBTRACT;
	public static int GL_CONSTANT;
	public static int GL_PRIMARY_COLOR;
	public static int GL_PREVIOUS;
	public static int GL_DOT3_RGB;
	public static int GL_DOT3_RGBA;
	public static int GL_CLAMP_TO_BORDER;
	public static int GL_TRANSPOSE_MODELVIEW_MATRIX;
	public static int GL_TRANSPOSE_PROJECTION_MATRIX;
	public static int GL_TRANSPOSE_TEXTURE_MATRIX;
	public static int GL_TRANSPOSE_COLOR_MATRIX;
	public static int GL_ALIASED_POINT_SIZE_RANGE;
	public static int GL_ALIASED_LINE_WIDTH_RANGE;
	public static int GL_SMOOTH_POINT_SIZE_RANGE;
	public static int GL_SMOOTH_POINT_SIZE_GRANULARITY;
	public static int GL_SMOOTH_LINE_WIDTH_RANGE;
	public static int GL_SMOOTH_LINE_WIDTH_GRANULARITY;
	public static int GL_TEXTURE_BINDING_3D;
	public static int GL_PACK_SKIP_IMAGES;
	public static int GL_PACK_IMAGE_HEIGHT;
	public static int GL_UNPACK_SKIP_IMAGES;
	public static int GL_UNPACK_IMAGE_HEIGHT;
	public static int GL_TEXTURE_3D;
	public static int GL_PROXY_TEXTURE_3D;
	public static int GL_TEXTURE_DEPTH;
	public static int GL_TEXTURE_WRAP_R;
	public static int GL_MAX_3D_TEXTURE_SIZE;
	public static int GL_BGR;
	public static int GL_BGRA;
	public static int GL_UNSIGNED_BYTE_3_3_2;
	public static int GL_UNSIGNED_BYTE_2_3_3_REV;
	public static int GL_UNSIGNED_SHORT_5_6_5;
	public static int GL_UNSIGNED_SHORT_5_6_5_REV;
	public static int GL_UNSIGNED_SHORT_4_4_4_4;
	public static int GL_UNSIGNED_SHORT_4_4_4_4_REV;
	public static int GL_UNSIGNED_SHORT_5_5_5_1;
	public static int GL_UNSIGNED_SHORT_1_5_5_5_REV;
	public static int GL_UNSIGNED_INT_8_8_8_8;
	public static int GL_UNSIGNED_INT_8_8_8_8_REV;
	public static int GL_UNSIGNED_INT_10_10_10_2;
	public static int GL_UNSIGNED_INT_2_10_10_10_REV;
	public static int GL_RESCALE_NORMAL;
	public static int GL_LIGHT_MODEL_COLOR_CONTROL;
	public static int GL_SINGLE_COLOR;
	public static int GL_SEPARATE_SPECULAR_COLOR;
	public static int GL_CLAMP_TO_EDGE;
	public static int GL_TEXTURE_MIN_LOD;
	public static int GL_TEXTURE_MAX_LOD;
	public static int GL_TEXTURE_BASE_LEVEL;
	public static int GL_TEXTURE_MAX_LEVEL;
	public static int GL_MAX_ELEMENTS_VERTICES;
	public static int GL_MAX_ELEMENTS_INDICES;
	public static int GL_ACCUM;
	public static int GL_LOAD;
	public static int GL_RETURN;
	public static int GL_MULT;
	public static int GL_ADD;
	public static int GL_NEVER;
	public static int GL_LESS;
	public static int GL_EQUAL;
	public static int GL_LEQUAL;
	public static int GL_GREATER;
	public static int GL_NOTEQUAL;
	public static int GL_GEQUAL;
	public static int GL_ALWAYS;
	public static int GL_CURRENT_BIT;
	public static int GL_POINT_BIT;
	public static int GL_LINE_BIT;
	public static int GL_POLYGON_BIT;
	public static int GL_POLYGON_STIPPLE_BIT;
	public static int GL_PIXEL_MODE_BIT;
	public static int GL_LIGHTING_BIT;
	public static int GL_FOG_BIT;
	public static int GL_DEPTH_BUFFER_BIT;
	public static int GL_ACCUM_BUFFER_BIT;
	public static int GL_STENCIL_BUFFER_BIT;
	public static int GL_VIEWPORT_BIT;
	public static int GL_TRANSFORM_BIT;
	public static int GL_ENABLE_BIT;
	public static int GL_COLOR_BUFFER_BIT;
	public static int GL_HINT_BIT;
	public static int GL_EVAL_BIT;
	public static int GL_LIST_BIT;
	public static int GL_TEXTURE_BIT;
	public static int GL_SCISSOR_BIT;
	public static int GL_ALL_ATTRIB_BITS;
	public static int GL_POINTS;
	public static int GL_LINES;
	public static int GL_LINE_LOOP;
	public static int GL_LINE_STRIP;
	public static int GL_TRIANGLES;
	public static int GL_TRIANGLE_STRIP;
	public static int GL_TRIANGLE_FAN;
	public static int GL_QUADS;
	public static int GL_QUAD_STRIP;
	public static int GL_POLYGON;
	public static int GL_ZERO;
	public static int GL_ONE;
	public static int GL_SRC_COLOR;
	public static int GL_ONE_MINUS_SRC_COLOR;
	public static int GL_SRC_ALPHA;
	public static int GL_ONE_MINUS_SRC_ALPHA;
	public static int GL_DST_ALPHA;
	public static int GL_ONE_MINUS_DST_ALPHA;
	public static int GL_DST_COLOR;
	public static int GL_ONE_MINUS_DST_COLOR;
	public static int GL_SRC_ALPHA_SATURATE;
	public static int GL_TRUE;
	public static int GL_FALSE;
	public static int GL_CLIP_PLANE0;
	public static int GL_CLIP_PLANE1;
	public static int GL_CLIP_PLANE2;
	public static int GL_CLIP_PLANE3;
	public static int GL_CLIP_PLANE4;
	public static int GL_CLIP_PLANE5;
	public static int GL_BYTE;
	public static int GL_UNSIGNED_BYTE;
	public static int GL_SHORT;
	public static int GL_UNSIGNED_SHORT;
	public static int GL_INT;
	public static int GL_UNSIGNED_INT;
	public static int GL_FLOAT;
	public static int GL_2_BYTES;
	public static int GL_3_BYTES;
	public static int GL_4_BYTES;
	public static int GL_DOUBLE;
	public static int GL_NONE;
	public static int GL_FRONT_LEFT;
	public static int GL_FRONT_RIGHT;
	public static int GL_BACK_LEFT;
	public static int GL_BACK_RIGHT;
	public static int GL_FRONT;
	public static int GL_BACK;
	public static int GL_LEFT;
	public static int GL_RIGHT;
	public static int GL_FRONT_AND_BACK;
	public static int GL_AUX0;
	public static int GL_AUX1;
	public static int GL_AUX2;
	public static int GL_AUX3;
	public static int GL_NO_ERROR;
	public static int GL_INVALID_ENUM;
	public static int GL_INVALID_VALUE;
	public static int GL_INVALID_OPERATION;
	public static int GL_STACK_OVERFLOW;
	public static int GL_STACK_UNDERFLOW;
	public static int GL_OUT_OF_MEMORY;
	public static int GL_2D;
	public static int GL_3D;
	public static int GL_3D_COLOR;
	public static int GL_3D_COLOR_TEXTURE;
	public static int GL_4D_COLOR_TEXTURE;
	public static int GL_PASS_THROUGH_TOKEN;
	public static int GL_POINT_TOKEN;
	public static int GL_LINE_TOKEN;
	public static int GL_POLYGON_TOKEN;
	public static int GL_BITMAP_TOKEN;
	public static int GL_DRAW_PIXEL_TOKEN;
	public static int GL_COPY_PIXEL_TOKEN;
	public static int GL_LINE_RESET_TOKEN;
	public static int GL_EXP;
	public static int GL_EXP2;
	public static int GL_CW;
	public static int GL_CCW;
	public static int GL_COEFF;
	public static int GL_ORDER;
	public static int GL_DOMAIN;
	public static int GL_CURRENT_COLOR;
	public static int GL_CURRENT_INDEX;
	public static int GL_CURRENT_NORMAL;
	public static int GL_CURRENT_TEXTURE_COORDS;
	public static int GL_CURRENT_RASTER_COLOR;
	public static int GL_CURRENT_RASTER_INDEX;
	public static int GL_CURRENT_RASTER_TEXTURE_COORDS;
	public static int GL_CURRENT_RASTER_POSITION;
	public static int GL_CURRENT_RASTER_POSITION_VALID;
	public static int GL_CURRENT_RASTER_DISTANCE;
	public static int GL_POINT_SMOOTH;
	public static int GL_POINT_SIZE;
	public static int GL_POINT_SIZE_RANGE;
	public static int GL_POINT_SIZE_GRANULARITY;
	public static int GL_LINE_SMOOTH;
	public static int GL_LINE_WIDTH;
	public static int GL_LINE_WIDTH_RANGE;
	public static int GL_LINE_WIDTH_GRANULARITY;
	public static int GL_LINE_STIPPLE;
	public static int GL_LINE_STIPPLE_PATTERN;
	public static int GL_LINE_STIPPLE_REPEAT;
	public static int GL_LIST_MODE;
	public static int GL_MAX_LIST_NESTING;
	public static int GL_LIST_BASE;
	public static int GL_LIST_INDEX;
	public static int GL_POLYGON_MODE;
	public static int GL_POLYGON_SMOOTH;
	public static int GL_POLYGON_STIPPLE;
	public static int GL_EDGE_FLAG;
	public static int GL_CULL_FACE;
	public static int GL_CULL_FACE_MODE;
	public static int GL_FRONT_FACE;
	public static int GL_LIGHTING;
	public static int GL_LIGHT_MODEL_LOCAL_VIEWER;
	public static int GL_LIGHT_MODEL_TWO_SIDE;
	public static int GL_LIGHT_MODEL_AMBIENT;
	public static int GL_SHADE_MODEL;
	public static int GL_COLOR_MATERIAL_FACE;
	public static int GL_COLOR_MATERIAL_PARAMETER;
	public static int GL_COLOR_MATERIAL;
	public static int GL_FOG;
	public static int GL_FOG_INDEX;
	public static int GL_FOG_DENSITY;
	public static int GL_FOG_START;
	public static int GL_FOG_END;
	public static int GL_FOG_MODE;
	public static int GL_FOG_COLOR;
	public static int GL_DEPTH_RANGE;
	public static int GL_DEPTH_TEST;
	public static int GL_DEPTH_WRITEMASK;
	public static int GL_DEPTH_CLEAR_VALUE;
	public static int GL_DEPTH_FUNC;
	public static int GL_ACCUM_CLEAR_VALUE;
	public static int GL_STENCIL_TEST;
	public static int GL_STENCIL_CLEAR_VALUE;
	public static int GL_STENCIL_FUNC;
	public static int GL_STENCIL_VALUE_MASK;
	public static int GL_STENCIL_FAIL;
	public static int GL_STENCIL_PASS_DEPTH_FAIL;
	public static int GL_STENCIL_PASS_DEPTH_PASS;
	public static int GL_STENCIL_REF;
	public static int GL_STENCIL_WRITEMASK;
	public static int GL_MATRIX_MODE;
	public static int GL_NORMALIZE;
	public static int GL_VIEWPORT;
	public static int GL_MODELVIEW_STACK_DEPTH;
	public static int GL_PROJECTION_STACK_DEPTH;
	public static int GL_TEXTURE_STACK_DEPTH;
	public static int GL_MODELVIEW_MATRIX;
	public static int GL_PROJECTION_MATRIX;
	public static int GL_TEXTURE_MATRIX;
	public static int GL_ATTRIB_STACK_DEPTH;
	public static int GL_CLIENT_ATTRIB_STACK_DEPTH;
	public static int GL_ALPHA_TEST;
	public static int GL_ALPHA_TEST_FUNC;
	public static int GL_ALPHA_TEST_REF;
	public static int GL_DITHER;
	public static int GL_BLEND_DST;
	public static int GL_BLEND_SRC;
	public static int GL_BLEND;
	public static int GL_LOGIC_OP_MODE;
	public static int GL_INDEX_LOGIC_OP;
	public static int GL_LOGIC_OP;
	public static int GL_COLOR_LOGIC_OP;
	public static int GL_AUX_BUFFERS;
	public static int GL_DRAW_BUFFER;
	public static int GL_READ_BUFFER;
	public static int GL_SCISSOR_BOX;
	public static int GL_SCISSOR_TEST;
	public static int GL_INDEX_CLEAR_VALUE;
	public static int GL_INDEX_WRITEMASK;
	public static int GL_COLOR_CLEAR_VALUE;
	public static int GL_COLOR_WRITEMASK;
	public static int GL_INDEX_MODE;
	public static int GL_RGBA_MODE;
	public static int GL_DOUBLEBUFFER;
	public static int GL_STEREO;
	public static int GL_RENDER_MODE;
	public static int GL_PERSPECTIVE_CORRECTION_HINT;
	public static int GL_POINT_SMOOTH_HINT;
	public static int GL_LINE_SMOOTH_HINT;
	public static int GL_POLYGON_SMOOTH_HINT;
	public static int GL_FOG_HINT;
	public static int GL_TEXTURE_GEN_S;
	public static int GL_TEXTURE_GEN_T;
	public static int GL_TEXTURE_GEN_R;
	public static int GL_TEXTURE_GEN_Q;
	public static int GL_PIXEL_MAP_I_TO_I;
	public static int GL_PIXEL_MAP_S_TO_S;
	public static int GL_PIXEL_MAP_I_TO_R;
	public static int GL_PIXEL_MAP_I_TO_G;
	public static int GL_PIXEL_MAP_I_TO_B;
	public static int GL_PIXEL_MAP_I_TO_A;
	public static int GL_PIXEL_MAP_R_TO_R;
	public static int GL_PIXEL_MAP_G_TO_G;
	public static int GL_PIXEL_MAP_B_TO_B;
	public static int GL_PIXEL_MAP_A_TO_A;
	public static int GL_PIXEL_MAP_I_TO_I_SIZE;
	public static int GL_PIXEL_MAP_S_TO_S_SIZE;
	public static int GL_PIXEL_MAP_I_TO_R_SIZE;
	public static int GL_PIXEL_MAP_I_TO_G_SIZE;
	public static int GL_PIXEL_MAP_I_TO_B_SIZE;
	public static int GL_PIXEL_MAP_I_TO_A_SIZE;
	public static int GL_PIXEL_MAP_R_TO_R_SIZE;
	public static int GL_PIXEL_MAP_G_TO_G_SIZE;
	public static int GL_PIXEL_MAP_B_TO_B_SIZE;
	public static int GL_PIXEL_MAP_A_TO_A_SIZE;
	public static int GL_UNPACK_SWAP_BYTES;
	public static int GL_UNPACK_LSB_FIRST;
	public static int GL_UNPACK_ROW_LENGTH;
	public static int GL_UNPACK_SKIP_ROWS;
	public static int GL_UNPACK_SKIP_PIXELS;
	public static int GL_UNPACK_ALIGNMENT;
	public static int GL_PACK_SWAP_BYTES;
	public static int GL_PACK_LSB_FIRST;
	public static int GL_PACK_ROW_LENGTH;
	public static int GL_PACK_SKIP_ROWS;
	public static int GL_PACK_SKIP_PIXELS;
	public static int GL_PACK_ALIGNMENT;
	public static int GL_MAP_COLOR;
	public static int GL_MAP_STENCIL;
	public static int GL_INDEX_SHIFT;
	public static int GL_INDEX_OFFSET;
	public static int GL_RED_SCALE;
	public static int GL_RED_BIAS;
	public static int GL_ZOOM_X;
	public static int GL_ZOOM_Y;
	public static int GL_GREEN_SCALE;
	public static int GL_GREEN_BIAS;
	public static int GL_BLUE_SCALE;
	public static int GL_BLUE_BIAS;
	public static int GL_ALPHA_SCALE;
	public static int GL_ALPHA_BIAS;
	public static int GL_DEPTH_SCALE;
	public static int GL_DEPTH_BIAS;
	public static int GL_MAX_EVAL_ORDER;
	public static int GL_MAX_LIGHTS;
	public static int GL_MAX_CLIP_PLANES;
	public static int GL_MAX_TEXTURE_SIZE;
	public static int GL_MAX_PIXEL_MAP_TABLE;
	public static int GL_MAX_ATTRIB_STACK_DEPTH;
	public static int GL_MAX_MODELVIEW_STACK_DEPTH;
	public static int GL_MAX_NAME_STACK_DEPTH;
	public static int GL_MAX_PROJECTION_STACK_DEPTH;
	public static int GL_MAX_TEXTURE_STACK_DEPTH;
	public static int GL_MAX_VIEWPORT_DIMS;
	public static int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH;
	public static int GL_SUBPIXEL_BITS;
	public static int GL_INDEX_BITS;
	public static int GL_RED_BITS;
	public static int GL_GREEN_BITS;
	public static int GL_BLUE_BITS;
	public static int GL_ALPHA_BITS;
	public static int GL_DEPTH_BITS;
	public static int GL_STENCIL_BITS;
	public static int GL_ACCUM_RED_BITS;
	public static int GL_ACCUM_GREEN_BITS;
	public static int GL_ACCUM_BLUE_BITS;
	public static int GL_ACCUM_ALPHA_BITS;
	public static int GL_NAME_STACK_DEPTH;
	public static int GL_AUTO_NORMAL;
	public static int GL_MAP1_COLOR_4;
	public static int GL_MAP1_INDEX;
	public static int GL_MAP1_NORMAL;
	public static int GL_MAP1_TEXTURE_COORD_1;
	public static int GL_MAP1_TEXTURE_COORD_2;
	public static int GL_MAP1_TEXTURE_COORD_3;
	public static int GL_MAP1_TEXTURE_COORD_4;
	public static int GL_MAP1_VERTEX_3;
	public static int GL_MAP1_VERTEX_4;
	public static int GL_MAP2_COLOR_4;
	public static int GL_MAP2_INDEX;
	public static int GL_MAP2_NORMAL;
	public static int GL_MAP2_TEXTURE_COORD_1;
	public static int GL_MAP2_TEXTURE_COORD_2;
	public static int GL_MAP2_TEXTURE_COORD_3;
	public static int GL_MAP2_TEXTURE_COORD_4;
	public static int GL_MAP2_VERTEX_3;
	public static int GL_MAP2_VERTEX_4;
	public static int GL_MAP1_GRID_DOMAIN;
	public static int GL_MAP1_GRID_SEGMENTS;
	public static int GL_MAP2_GRID_DOMAIN;
	public static int GL_MAP2_GRID_SEGMENTS;
	public static int GL_TEXTURE_1D;
	public static int GL_TEXTURE_2D;
	public static int GL_FEEDBACK_BUFFER_POINTER;
	public static int GL_FEEDBACK_BUFFER_SIZE;
	public static int GL_FEEDBACK_BUFFER_TYPE;
	public static int GL_SELECTION_BUFFER_POINTER;
	public static int GL_SELECTION_BUFFER_SIZE;
	public static int GL_TEXTURE_WIDTH;
	public static int GL_TEXTURE_HEIGHT;
	public static int GL_TEXTURE_INTERNAL_FORMAT;
	public static int GL_TEXTURE_COMPONENTS;
	public static int GL_TEXTURE_BORDER_COLOR;
	public static int GL_TEXTURE_BORDER;
	public static int GL_DONT_CARE;
	public static int GL_FASTEST;
	public static int GL_NICEST;
	public static int GL_LIGHT0;
	public static int GL_LIGHT1;
	public static int GL_LIGHT2;
	public static int GL_LIGHT3;
	public static int GL_LIGHT4;
	public static int GL_LIGHT5;
	public static int GL_LIGHT6;
	public static int GL_LIGHT7;
	public static int GL_AMBIENT;
	public static int GL_DIFFUSE;
	public static int GL_SPECULAR;
	public static int GL_POSITION;
	public static int GL_SPOT_DIRECTION;
	public static int GL_SPOT_EXPONENT;
	public static int GL_SPOT_CUTOFF;
	public static int GL_CONSTANT_ATTENUATION;
	public static int GL_LINEAR_ATTENUATION;
	public static int GL_QUADRATIC_ATTENUATION;
	public static int GL_COMPILE;
	public static int GL_COMPILE_AND_EXECUTE;
	public static int GL_CLEAR;
	public static int GL_AND;
	public static int GL_AND_REVERSE;
	public static int GL_COPY;
	public static int GL_AND_INVERTED;
	public static int GL_NOOP;
	public static int GL_XOR;
	public static int GL_OR;
	public static int GL_NOR;
	public static int GL_EQUIV;
	public static int GL_INVERT;
	public static int GL_OR_REVERSE;
	public static int GL_COPY_INVERTED;
	public static int GL_OR_INVERTED;
	public static int GL_NAND;
	public static int GL_SET;
	public static int GL_EMISSION;
	public static int GL_SHININESS;
	public static int GL_AMBIENT_AND_DIFFUSE;
	public static int GL_COLOR_INDEXES;
	public static int GL_MODELVIEW;
	public static int GL_PROJECTION;
	public static int GL_TEXTURE;
	public static int GL_COLOR;
	public static int GL_DEPTH;
	public static int GL_STENCIL;
	public static int GL_COLOR_INDEX;
	public static int GL_STENCIL_INDEX;
	public static int GL_DEPTH_COMPONENT;
	public static int GL_RED;
	public static int GL_GREEN;
	public static int GL_BLUE;
	public static int GL_ALPHA;
	public static int GL_RGB;
	public static int GL_RGBA;
	public static int GL_LUMINANCE;
	public static int GL_LUMINANCE_ALPHA;
	public static int GL_BITMAP;
	public static int GL_POINT;
	public static int GL_LINE;
	public static int GL_FILL;
	public static int GL_RENDER;
	public static int GL_FEEDBACK;
	public static int GL_SELECT;
	public static int GL_FLAT;
	public static int GL_SMOOTH;
	public static int GL_KEEP;
	public static int GL_REPLACE;
	public static int GL_INCR;
	public static int GL_DECR;
	public static int GL_VENDOR;
	public static int GL_RENDERER;
	public static int GL_VERSION;
	public static int GL_EXTENSIONS;
	public static int GL_S;
	public static int GL_T;
	public static int GL_R;
	public static int GL_Q;
	public static int GL_MODULATE;
	public static int GL_DECAL;
	public static int GL_TEXTURE_ENV_MODE;
	public static int GL_TEXTURE_ENV_COLOR;
	public static int GL_TEXTURE_ENV;
	public static int GL_EYE_LINEAR;
	public static int GL_OBJECT_LINEAR;
	public static int GL_SPHERE_MAP;
	public static int GL_TEXTURE_GEN_MODE;
	public static int GL_OBJECT_PLANE;
	public static int GL_EYE_PLANE;
	public static int GL_NEAREST;
	public static int GL_LINEAR;
	public static int GL_NEAREST_MIPMAP_NEAREST;
	public static int GL_LINEAR_MIPMAP_NEAREST;
	public static int GL_NEAREST_MIPMAP_LINEAR;
	public static int GL_LINEAR_MIPMAP_LINEAR;
	public static int GL_TEXTURE_MAG_FILTER;
	public static int GL_TEXTURE_MIN_FILTER;
	public static int GL_TEXTURE_WRAP_S;
	public static int GL_TEXTURE_WRAP_T;
	public static int GL_CLAMP;
	public static int GL_REPEAT;
	public static int GL_CLIENT_PIXEL_STORE_BIT;
	public static int GL_CLIENT_VERTEX_ARRAY_BIT;
	public static int GL_CLIENT_ALL_ATTRIB_BITS;
	public static int GL_POLYGON_OFFSET_FACTOR;
	public static int GL_POLYGON_OFFSET_UNITS;
	public static int GL_POLYGON_OFFSET_POINT;
	public static int GL_POLYGON_OFFSET_LINE;
	public static int GL_POLYGON_OFFSET_FILL;
	public static int GL_ALPHA4;
	public static int GL_ALPHA8;
	public static int GL_ALPHA12;
	public static int GL_ALPHA16;
	public static int GL_LUMINANCE4;
	public static int GL_LUMINANCE8;
	public static int GL_LUMINANCE12;
	public static int GL_LUMINANCE16;
	public static int GL_LUMINANCE4_ALPHA4;
	public static int GL_LUMINANCE6_ALPHA2;
	public static int GL_LUMINANCE8_ALPHA8;
	public static int GL_LUMINANCE12_ALPHA4;
	public static int GL_LUMINANCE12_ALPHA12;
	public static int GL_LUMINANCE16_ALPHA16;
	public static int GL_INTENSITY;
	public static int GL_INTENSITY4;
	public static int GL_INTENSITY8;
	public static int GL_INTENSITY12;
	public static int GL_INTENSITY16;
	public static int GL_R3_G3_B2;
	public static int GL_RGB4;
	public static int GL_RGB5;
	public static int GL_RGB8;
	public static int GL_RGB10;
	public static int GL_RGB12;
	public static int GL_RGB16;
	public static int GL_RGBA2;
	public static int GL_RGBA4;
	public static int GL_RGB5_A1;
	public static int GL_RGBA8;
	public static int GL_RGB10_A2;
	public static int GL_RGBA12;
	public static int GL_RGBA16;
	public static int GL_TEXTURE_RED_SIZE;
	public static int GL_TEXTURE_GREEN_SIZE;
	public static int GL_TEXTURE_BLUE_SIZE;
	public static int GL_TEXTURE_ALPHA_SIZE;
	public static int GL_TEXTURE_LUMINANCE_SIZE;
	public static int GL_TEXTURE_INTENSITY_SIZE;
	public static int GL_PROXY_TEXTURE_1D;
	public static int GL_PROXY_TEXTURE_2D;
	public static int GL_TEXTURE_PRIORITY;
	public static int GL_TEXTURE_RESIDENT;
	public static int GL_TEXTURE_BINDING_1D;
	public static int GL_TEXTURE_BINDING_2D;
	public static int GL_VERTEX_ARRAY;
	public static int GL_NORMAL_ARRAY;
	public static int GL_COLOR_ARRAY;
	public static int GL_INDEX_ARRAY;
	public static int GL_TEXTURE_COORD_ARRAY;
	public static int GL_EDGE_FLAG_ARRAY;
	public static int GL_VERTEX_ARRAY_SIZE;
	public static int GL_VERTEX_ARRAY_TYPE;
	public static int GL_VERTEX_ARRAY_STRIDE;
	public static int GL_NORMAL_ARRAY_TYPE;
	public static int GL_NORMAL_ARRAY_STRIDE;
	public static int GL_COLOR_ARRAY_SIZE;
	public static int GL_COLOR_ARRAY_TYPE;
	public static int GL_COLOR_ARRAY_STRIDE;
	public static int GL_INDEX_ARRAY_TYPE;
	public static int GL_INDEX_ARRAY_STRIDE;
	public static int GL_TEXTURE_COORD_ARRAY_SIZE;
	public static int GL_TEXTURE_COORD_ARRAY_TYPE;
	public static int GL_TEXTURE_COORD_ARRAY_STRIDE;
	public static int GL_EDGE_FLAG_ARRAY_STRIDE;
	public static int GL_VERTEX_ARRAY_POINTER;
	public static int GL_NORMAL_ARRAY_POINTER;
	public static int GL_COLOR_ARRAY_POINTER;
	public static int GL_INDEX_ARRAY_POINTER;
	public static int GL_TEXTURE_COORD_ARRAY_POINTER;
	public static int GL_EDGE_FLAG_ARRAY_POINTER;
	public static int GL_V2F;
	public static int GL_V3F;
	public static int GL_C4UB_V2F;
	public static int GL_C4UB_V3F;
	public static int GL_C3F_V3F;
	public static int GL_N3F_V3F;
	public static int GL_C4F_N3F_V3F;
	public static int GL_T2F_V3F;
	public static int GL_T4F_V4F;
	public static int GL_T2F_C4UB_V3F;
	public static int GL_T2F_C3F_V3F;
	public static int GL_T2F_N3F_V3F;
	public static int GL_T2F_C4F_N3F_V3F;
	public static int GL_T4F_C4F_N3F_V4F;
	public static int GL_DRAW_INDIRECT_BUFFER;
	public static int GL_DRAW_INDIRECT_BUFFER_BINDING;
	public static int GL_GEOMETRY_SHADER_INVOCATIONS;
	public static int GL_MAX_GEOMETRY_SHADER_INVOCATIONS;
	public static int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET;
	public static int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET;
	public static int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS;
	public static int GL_DOUBLE_VEC2;
	public static int GL_DOUBLE_VEC3;
	public static int GL_DOUBLE_VEC4;
	public static int GL_DOUBLE_MAT2;
	public static int GL_DOUBLE_MAT3;
	public static int GL_DOUBLE_MAT4;
	public static int GL_DOUBLE_MAT2x3;
	public static int GL_DOUBLE_MAT2x4;
	public static int GL_DOUBLE_MAT3x2;
	public static int GL_DOUBLE_MAT3x4;
	public static int GL_DOUBLE_MAT4x2;
	public static int GL_DOUBLE_MAT4x3;
	public static int GL_SAMPLE_SHADING;
	public static int GL_MIN_SAMPLE_SHADING_VALUE;
	public static int GL_ACTIVE_SUBROUTINES;
	public static int GL_ACTIVE_SUBROUTINE_UNIFORMS;
	public static int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS;
	public static int GL_ACTIVE_SUBROUTINE_MAX_LENGTH;
	public static int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH;
	public static int GL_MAX_SUBROUTINES;
	public static int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS;
	public static int GL_NUM_COMPATIBLE_SUBROUTINES;
	public static int GL_COMPATIBLE_SUBROUTINES;
	public static int GL_PATCHES;
	public static int GL_PATCH_VERTICES;
	public static int GL_PATCH_DEFAULT_INNER_LEVEL;
	public static int GL_PATCH_DEFAULT_OUTER_LEVEL;
	public static int GL_TESS_CONTROL_OUTPUT_VERTICES;
	public static int GL_TESS_GEN_MODE;
	public static int GL_TESS_GEN_SPACING;
	public static int GL_TESS_GEN_VERTEX_ORDER;
	public static int GL_TESS_GEN_POINT_MODE;
	public static int GL_ISOLINES;
	public static int GL_FRACTIONAL_ODD;
	public static int GL_FRACTIONAL_EVEN;
	public static int GL_MAX_PATCH_VERTICES;
	public static int GL_MAX_TESS_GEN_LEVEL;
	public static int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS;
	public static int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS;
	public static int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS;
	public static int GL_MAX_TESS_PATCH_COMPONENTS;
	public static int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS;
	public static int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS;
	public static int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS;
	public static int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS;
	public static int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS;
	public static int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS;
	public static int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS;
	public static int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER;
	public static int GL_TESS_EVALUATION_SHADER;
	public static int GL_TESS_CONTROL_SHADER;
	public static int GL_TEXTURE_CUBE_MAP_ARRAY;
	public static int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY;
	public static int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY;
	public static int GL_SAMPLER_CUBE_MAP_ARRAY;
	public static int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW;
	public static int GL_INT_SAMPLER_CUBE_MAP_ARRAY;
	public static int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY;
	public static int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET;
	public static int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET;
	public static int GL_TRANSFORM_FEEDBACK;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE;
	public static int GL_TRANSFORM_FEEDBACK_BINDING;
	public static int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS;
	public static int GL_MAX_VERTEX_STREAMS;
	public static int GL_BLEND_EQUATION;
	public static int GL_BLEND_COLOR;
	public static int GL_FIXED;
	public static int GL_MAX_VERTEX_UNIFORM_VECTORS;
	public static int GL_MAX_VARYING_VECTORS;
	public static int GL_MAX_FRAGMENT_UNIFORM_VECTORS;
	public static int GL_IMPLEMENTATION_COLOR_READ_TYPE;
	public static int GL_IMPLEMENTATION_COLOR_READ_FORMAT;
	public static int GL_SHADER_COMPILER;
	public static int GL_SHADER_BINARY_FORMATS;
	public static int GL_NUM_SHADER_BINARY_FORMATS;
	public static int GL_LOW_FLOAT;
	public static int GL_MEDIUM_FLOAT;
	public static int GL_HIGH_FLOAT;
	public static int GL_LOW_INT;
	public static int GL_MEDIUM_INT;
	public static int GL_HIGH_INT;
	public static int GL_RGB565;
	public static int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
	public static int GL_PRIMITIVE_RESTART_FIXED_INDEX;
	public static int GL_COPY_READ_BUFFER_BINDING;
	public static int GL_COPY_WRITE_BUFFER_BINDING;
	public static int GL_ANY_SAMPLES_PASSED_CONSERVATIVE;
	public static int GL_TRANSFORM_FEEDBACK_PAUSED;
	public static int GL_TRANSFORM_FEEDBACK_ACTIVE;
	public static int GL_PROGRAM_BINARY_RETRIEVABLE_HINT;
	public static int GL_PROGRAM_BINARY_LENGTH;
	public static int GL_NUM_PROGRAM_BINARY_FORMATS;
	public static int GL_PROGRAM_BINARY_FORMATS;
	public static int GL_COMPRESSED_R11_EAC;
	public static int GL_COMPRESSED_SIGNED_R11_EAC;
	public static int GL_COMPRESSED_RG11_EAC;
	public static int GL_COMPRESSED_SIGNED_RG11_EAC;
	public static int GL_COMPRESSED_RGB8_ETC2;
	public static int GL_COMPRESSED_SRGB8_ETC2;
	public static int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2;
	public static int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2;
	public static int GL_COMPRESSED_RGBA8_ETC2_EAC;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC;
	public static int GL_TEXTURE_IMMUTABLE_FORMAT;
	public static int GL_MAX_ELEMENT_INDEX;
	public static int GL_NUM_SAMPLE_COUNTS;
	public static int GL_TEXTURE_IMMUTABLE_LEVELS;
	public static int GL_PARAMETER_BUFFER;
	public static int GL_PARAMETER_BUFFER_BINDING;
	public static int GL_VERTICES_SUBMITTED;
	public static int GL_PRIMITIVES_SUBMITTED;
	public static int GL_VERTEX_SHADER_INVOCATIONS;
	public static int GL_TESS_CONTROL_SHADER_PATCHES;
	public static int GL_TESS_EVALUATION_SHADER_INVOCATIONS;
	public static int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED;
	public static int GL_FRAGMENT_SHADER_INVOCATIONS;
	public static int GL_COMPUTE_SHADER_INVOCATIONS;
	public static int GL_CLIPPING_INPUT_PRIMITIVES;
	public static int GL_CLIPPING_OUTPUT_PRIMITIVES;
	public static int GL_POLYGON_OFFSET_CLAMP;
	public static int GL_CONTEXT_FLAG_NO_ERROR_BIT;
	public static int GL_SHADER_BINARY_FORMAT_SPIR_V;
	public static int GL_SPIR_V_BINARY;
	public static int GL_SPIR_V_EXTENSIONS;
	public static int GL_NUM_SPIR_V_EXTENSIONS;
	public static int GL_TEXTURE_MAX_ANISOTROPY;
	public static int GL_MAX_TEXTURE_MAX_ANISOTROPY;
	public static int GL_TRANSFORM_FEEDBACK_OVERFLOW;
	public static int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW;
	public static int GL_NEGATIVE_ONE_TO_ONE;
	public static int GL_ZERO_TO_ONE;
	public static int GL_CLIP_ORIGIN;
	public static int GL_CLIP_DEPTH_MODE;
	public static int GL_QUERY_WAIT_INVERTED;
	public static int GL_QUERY_NO_WAIT_INVERTED;
	public static int GL_QUERY_BY_REGION_WAIT_INVERTED;
	public static int GL_QUERY_BY_REGION_NO_WAIT_INVERTED;
	public static int GL_MAX_CULL_DISTANCES;
	public static int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES;
	public static int GL_TEXTURE_TARGET;
	public static int GL_QUERY_TARGET;
	public static int GL_CONTEXT_RELEASE_BEHAVIOR;
	public static int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH;
	public static int GL_GUILTY_CONTEXT_RESET;
	public static int GL_INNOCENT_CONTEXT_RESET;
	public static int GL_UNKNOWN_CONTEXT_RESET;
	public static int GL_RESET_NOTIFICATION_STRATEGY;
	public static int GL_LOSE_CONTEXT_ON_RESET;
	public static int GL_NO_RESET_NOTIFICATION;
	public static int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT;
	public static int GL_CONTEXT_LOST;
	public static int GL_MAX_VERTEX_ATTRIB_STRIDE;
	public static int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED;
	public static int GL_TEXTURE_BUFFER_BINDING;
	public static int GL_MAP_PERSISTENT_BIT;
	public static int GL_MAP_COHERENT_BIT;
	public static int GL_DYNAMIC_STORAGE_BIT;
	public static int GL_CLIENT_STORAGE_BIT;
	public static int GL_BUFFER_IMMUTABLE_STORAGE;
	public static int GL_BUFFER_STORAGE_FLAGS;
	public static int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT;
	public static int GL_CLEAR_TEXTURE;
	public static int GL_LOCATION_COMPONENT;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX;
	public static int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE;
	public static int GL_QUERY_RESULT_NO_WAIT;
	public static int GL_QUERY_BUFFER;
	public static int GL_QUERY_BUFFER_BINDING;
	public static int GL_QUERY_BUFFER_BARRIER_BIT;
	public static int GL_MIRROR_CLAMP_TO_EDGE;
	public static int GL_NUM_SHADING_LANGUAGE_VERSIONS;
	public static int GL_VERTEX_ATTRIB_ARRAY_LONG;
	public static int GL_COMPUTE_SHADER;
	public static int GL_MAX_COMPUTE_UNIFORM_BLOCKS;
	public static int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS;
	public static int GL_MAX_COMPUTE_IMAGE_UNIFORMS;
	public static int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE;
	public static int GL_MAX_COMPUTE_UNIFORM_COMPONENTS;
	public static int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_COMPUTE_ATOMIC_COUNTERS;
	public static int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS;
	public static int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS;
	public static int GL_MAX_COMPUTE_WORK_GROUP_COUNT;
	public static int GL_MAX_COMPUTE_WORK_GROUP_SIZE;
	public static int GL_COMPUTE_WORK_GROUP_SIZE;
	public static int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER;
	public static int GL_DISPATCH_INDIRECT_BUFFER;
	public static int GL_DISPATCH_INDIRECT_BUFFER_BINDING;
	public static int GL_COMPUTE_SHADER_BIT;
	public static int GL_DEBUG_OUTPUT;
	public static int GL_DEBUG_OUTPUT_SYNCHRONOUS;
	public static int GL_CONTEXT_FLAG_DEBUG_BIT;
	public static int GL_MAX_DEBUG_MESSAGE_LENGTH;
	public static int GL_MAX_DEBUG_LOGGED_MESSAGES;
	public static int GL_DEBUG_LOGGED_MESSAGES;
	public static int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH;
	public static int GL_MAX_DEBUG_GROUP_STACK_DEPTH;
	public static int GL_DEBUG_GROUP_STACK_DEPTH;
	public static int GL_MAX_LABEL_LENGTH;
	public static int GL_DEBUG_CALLBACK_FUNCTION;
	public static int GL_DEBUG_CALLBACK_USER_PARAM;
	public static int GL_DEBUG_SOURCE_API;
	public static int GL_DEBUG_SOURCE_WINDOW_SYSTEM;
	public static int GL_DEBUG_SOURCE_SHADER_COMPILER;
	public static int GL_DEBUG_SOURCE_THIRD_PARTY;
	public static int GL_DEBUG_SOURCE_APPLICATION;
	public static int GL_DEBUG_SOURCE_OTHER;
	public static int GL_DEBUG_TYPE_ERROR;
	public static int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR;
	public static int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR;
	public static int GL_DEBUG_TYPE_PORTABILITY;
	public static int GL_DEBUG_TYPE_PERFORMANCE;
	public static int GL_DEBUG_TYPE_OTHER;
	public static int GL_DEBUG_TYPE_MARKER;
	public static int GL_DEBUG_TYPE_PUSH_GROUP;
	public static int GL_DEBUG_TYPE_POP_GROUP;
	public static int GL_DEBUG_SEVERITY_HIGH;
	public static int GL_DEBUG_SEVERITY_MEDIUM;
	public static int GL_DEBUG_SEVERITY_LOW;
	public static int GL_DEBUG_SEVERITY_NOTIFICATION;
	public static int GL_BUFFER;
	public static int GL_SHADER;
	public static int GL_PROGRAM;
	public static int GL_QUERY;
	public static int GL_PROGRAM_PIPELINE;
	public static int GL_SAMPLER;
	public static int GL_DISPLAY_LIST;
	public static int GL_MAX_UNIFORM_LOCATIONS;
	public static int GL_FRAMEBUFFER_DEFAULT_WIDTH;
	public static int GL_FRAMEBUFFER_DEFAULT_HEIGHT;
	public static int GL_FRAMEBUFFER_DEFAULT_LAYERS;
	public static int GL_FRAMEBUFFER_DEFAULT_SAMPLES;
	public static int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS;
	public static int GL_MAX_FRAMEBUFFER_WIDTH;
	public static int GL_MAX_FRAMEBUFFER_HEIGHT;
	public static int GL_MAX_FRAMEBUFFER_LAYERS;
	public static int GL_MAX_FRAMEBUFFER_SAMPLES;
	public static int GL_INTERNALFORMAT_SUPPORTED;
	public static int GL_INTERNALFORMAT_PREFERRED;
	public static int GL_INTERNALFORMAT_RED_SIZE;
	public static int GL_INTERNALFORMAT_GREEN_SIZE;
	public static int GL_INTERNALFORMAT_BLUE_SIZE;
	public static int GL_INTERNALFORMAT_ALPHA_SIZE;
	public static int GL_INTERNALFORMAT_DEPTH_SIZE;
	public static int GL_INTERNALFORMAT_STENCIL_SIZE;
	public static int GL_INTERNALFORMAT_SHARED_SIZE;
	public static int GL_INTERNALFORMAT_RED_TYPE;
	public static int GL_INTERNALFORMAT_GREEN_TYPE;
	public static int GL_INTERNALFORMAT_BLUE_TYPE;
	public static int GL_INTERNALFORMAT_ALPHA_TYPE;
	public static int GL_INTERNALFORMAT_DEPTH_TYPE;
	public static int GL_INTERNALFORMAT_STENCIL_TYPE;
	public static int GL_MAX_WIDTH;
	public static int GL_MAX_HEIGHT;
	public static int GL_MAX_DEPTH;
	public static int GL_MAX_LAYERS;
	public static int GL_MAX_COMBINED_DIMENSIONS;
	public static int GL_COLOR_COMPONENTS;
	public static int GL_DEPTH_COMPONENTS;
	public static int GL_STENCIL_COMPONENTS;
	public static int GL_COLOR_RENDERABLE;
	public static int GL_DEPTH_RENDERABLE;
	public static int GL_STENCIL_RENDERABLE;
	public static int GL_FRAMEBUFFER_RENDERABLE;
	public static int GL_FRAMEBUFFER_RENDERABLE_LAYERED;
	public static int GL_FRAMEBUFFER_BLEND;
	public static int GL_READ_PIXELS;
	public static int GL_READ_PIXELS_FORMAT;
	public static int GL_READ_PIXELS_TYPE;
	public static int GL_TEXTURE_IMAGE_FORMAT;
	public static int GL_TEXTURE_IMAGE_TYPE;
	public static int GL_GET_TEXTURE_IMAGE_FORMAT;
	public static int GL_GET_TEXTURE_IMAGE_TYPE;
	public static int GL_MIPMAP;
	public static int GL_MANUAL_GENERATE_MIPMAP;
	public static int GL_AUTO_GENERATE_MIPMAP;
	public static int GL_COLOR_ENCODING;
	public static int GL_SRGB_READ;
	public static int GL_SRGB_WRITE;
	public static int GL_FILTER;
	public static int GL_VERTEX_TEXTURE;
	public static int GL_TESS_CONTROL_TEXTURE;
	public static int GL_TESS_EVALUATION_TEXTURE;
	public static int GL_GEOMETRY_TEXTURE;
	public static int GL_FRAGMENT_TEXTURE;
	public static int GL_COMPUTE_TEXTURE;
	public static int GL_TEXTURE_SHADOW;
	public static int GL_TEXTURE_GATHER;
	public static int GL_TEXTURE_GATHER_SHADOW;
	public static int GL_SHADER_IMAGE_LOAD;
	public static int GL_SHADER_IMAGE_STORE;
	public static int GL_SHADER_IMAGE_ATOMIC;
	public static int GL_IMAGE_TEXEL_SIZE;
	public static int GL_IMAGE_COMPATIBILITY_CLASS;
	public static int GL_IMAGE_PIXEL_FORMAT;
	public static int GL_IMAGE_PIXEL_TYPE;
	public static int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST;
	public static int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST;
	public static int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE;
	public static int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE;
	public static int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH;
	public static int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT;
	public static int GL_TEXTURE_COMPRESSED_BLOCK_SIZE;
	public static int GL_CLEAR_BUFFER;
	public static int GL_TEXTURE_VIEW;
	public static int GL_VIEW_COMPATIBILITY_CLASS;
	public static int GL_FULL_SUPPORT;
	public static int GL_CAVEAT_SUPPORT;
	public static int GL_IMAGE_CLASS_4_X_32;
	public static int GL_IMAGE_CLASS_2_X_32;
	public static int GL_IMAGE_CLASS_1_X_32;
	public static int GL_IMAGE_CLASS_4_X_16;
	public static int GL_IMAGE_CLASS_2_X_16;
	public static int GL_IMAGE_CLASS_1_X_16;
	public static int GL_IMAGE_CLASS_4_X_8;
	public static int GL_IMAGE_CLASS_2_X_8;
	public static int GL_IMAGE_CLASS_1_X_8;
	public static int GL_IMAGE_CLASS_11_11_10;
	public static int GL_IMAGE_CLASS_10_10_10_2;
	public static int GL_VIEW_CLASS_128_BITS;
	public static int GL_VIEW_CLASS_96_BITS;
	public static int GL_VIEW_CLASS_64_BITS;
	public static int GL_VIEW_CLASS_48_BITS;
	public static int GL_VIEW_CLASS_32_BITS;
	public static int GL_VIEW_CLASS_24_BITS;
	public static int GL_VIEW_CLASS_16_BITS;
	public static int GL_VIEW_CLASS_8_BITS;
	public static int GL_VIEW_CLASS_S3TC_DXT1_RGB;
	public static int GL_VIEW_CLASS_S3TC_DXT1_RGBA;
	public static int GL_VIEW_CLASS_S3TC_DXT3_RGBA;
	public static int GL_VIEW_CLASS_S3TC_DXT5_RGBA;
	public static int GL_VIEW_CLASS_RGTC1_RED;
	public static int GL_VIEW_CLASS_RGTC2_RG;
	public static int GL_VIEW_CLASS_BPTC_UNORM;
	public static int GL_VIEW_CLASS_BPTC_FLOAT;
	public static int GL_UNIFORM;
	public static int GL_UNIFORM_BLOCK;
	public static int GL_PROGRAM_INPUT;
	public static int GL_PROGRAM_OUTPUT;
	public static int GL_BUFFER_VARIABLE;
	public static int GL_SHADER_STORAGE_BLOCK;
	public static int GL_VERTEX_SUBROUTINE;
	public static int GL_TESS_CONTROL_SUBROUTINE;
	public static int GL_TESS_EVALUATION_SUBROUTINE;
	public static int GL_GEOMETRY_SUBROUTINE;
	public static int GL_FRAGMENT_SUBROUTINE;
	public static int GL_COMPUTE_SUBROUTINE;
	public static int GL_VERTEX_SUBROUTINE_UNIFORM;
	public static int GL_TESS_CONTROL_SUBROUTINE_UNIFORM;
	public static int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM;
	public static int GL_GEOMETRY_SUBROUTINE_UNIFORM;
	public static int GL_FRAGMENT_SUBROUTINE_UNIFORM;
	public static int GL_COMPUTE_SUBROUTINE_UNIFORM;
	public static int GL_TRANSFORM_FEEDBACK_VARYING;
	public static int GL_ACTIVE_RESOURCES;
	public static int GL_MAX_NAME_LENGTH;
	public static int GL_MAX_NUM_ACTIVE_VARIABLES;
	public static int GL_MAX_NUM_COMPATIBLE_SUBROUTINES;
	public static int GL_NAME_LENGTH;
	public static int GL_TYPE;
	public static int GL_ARRAY_SIZE;
	public static int GL_OFFSET;
	public static int GL_BLOCK_INDEX;
	public static int GL_ARRAY_STRIDE;
	public static int GL_MATRIX_STRIDE;
	public static int GL_IS_ROW_MAJOR;
	public static int GL_ATOMIC_COUNTER_BUFFER_INDEX;
	public static int GL_BUFFER_BINDING;
	public static int GL_BUFFER_DATA_SIZE;
	public static int GL_NUM_ACTIVE_VARIABLES;
	public static int GL_ACTIVE_VARIABLES;
	public static int GL_REFERENCED_BY_VERTEX_SHADER;
	public static int GL_REFERENCED_BY_TESS_CONTROL_SHADER;
	public static int GL_REFERENCED_BY_TESS_EVALUATION_SHADER;
	public static int GL_REFERENCED_BY_GEOMETRY_SHADER;
	public static int GL_REFERENCED_BY_FRAGMENT_SHADER;
	public static int GL_REFERENCED_BY_COMPUTE_SHADER;
	public static int GL_TOP_LEVEL_ARRAY_SIZE;
	public static int GL_TOP_LEVEL_ARRAY_STRIDE;
	public static int GL_LOCATION;
	public static int GL_LOCATION_INDEX;
	public static int GL_IS_PER_PATCH;
	public static int GL_SHADER_STORAGE_BUFFER;
	public static int GL_SHADER_STORAGE_BUFFER_BINDING;
	public static int GL_SHADER_STORAGE_BUFFER_START;
	public static int GL_SHADER_STORAGE_BUFFER_SIZE;
	public static int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS;
	public static int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS;
	public static int GL_MAX_SHADER_STORAGE_BLOCK_SIZE;
	public static int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT;
	public static int GL_SHADER_STORAGE_BARRIER_BIT;
	public static int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES;
	public static int GL_DEPTH_STENCIL_TEXTURE_MODE;
	public static int GL_TEXTURE_BUFFER_OFFSET;
	public static int GL_TEXTURE_BUFFER_SIZE;
	public static int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT;
	public static int GL_TEXTURE_VIEW_MIN_LEVEL;
	public static int GL_TEXTURE_VIEW_NUM_LEVELS;
	public static int GL_TEXTURE_VIEW_MIN_LAYER;
	public static int GL_TEXTURE_VIEW_NUM_LAYERS;
	public static int GL_VERTEX_ATTRIB_BINDING;
	public static int GL_VERTEX_ATTRIB_RELATIVE_OFFSET;
	public static int GL_VERTEX_BINDING_DIVISOR;
	public static int GL_VERTEX_BINDING_OFFSET;
	public static int GL_VERTEX_BINDING_STRIDE;
	public static int GL_VERTEX_BINDING_BUFFER;
	public static int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET;
	public static int GL_MAX_VERTEX_ATTRIB_BINDINGS;
	public static int GL_COMPRESSED_RGBA_BPTC_UNORM;
	public static int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM;
	public static int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT;
	public static int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT;
	public static int GL_UNPACK_COMPRESSED_BLOCK_WIDTH;
	public static int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT;
	public static int GL_UNPACK_COMPRESSED_BLOCK_DEPTH;
	public static int GL_UNPACK_COMPRESSED_BLOCK_SIZE;
	public static int GL_PACK_COMPRESSED_BLOCK_WIDTH;
	public static int GL_PACK_COMPRESSED_BLOCK_HEIGHT;
	public static int GL_PACK_COMPRESSED_BLOCK_DEPTH;
	public static int GL_PACK_COMPRESSED_BLOCK_SIZE;
	public static int GL_ATOMIC_COUNTER_BUFFER;
	public static int GL_ATOMIC_COUNTER_BUFFER_BINDING;
	public static int GL_ATOMIC_COUNTER_BUFFER_START;
	public static int GL_ATOMIC_COUNTER_BUFFER_SIZE;
	public static int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE;
	public static int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS;
	public static int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER;
	public static int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER;
	public static int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS;
	public static int GL_MAX_VERTEX_ATOMIC_COUNTERS;
	public static int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS;
	public static int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS;
	public static int GL_MAX_GEOMETRY_ATOMIC_COUNTERS;
	public static int GL_MAX_FRAGMENT_ATOMIC_COUNTERS;
	public static int GL_MAX_COMBINED_ATOMIC_COUNTERS;
	public static int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE;
	public static int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS;
	public static int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS;
	public static int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX;
	public static int GL_UNSIGNED_INT_ATOMIC_COUNTER;
	public static int GL_MAX_IMAGE_UNITS;
	public static int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS;
	public static int GL_MAX_IMAGE_SAMPLES;
	public static int GL_MAX_VERTEX_IMAGE_UNIFORMS;
	public static int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS;
	public static int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS;
	public static int GL_MAX_GEOMETRY_IMAGE_UNIFORMS;
	public static int GL_MAX_FRAGMENT_IMAGE_UNIFORMS;
	public static int GL_MAX_COMBINED_IMAGE_UNIFORMS;
	public static int GL_IMAGE_BINDING_NAME;
	public static int GL_IMAGE_BINDING_LEVEL;
	public static int GL_IMAGE_BINDING_LAYERED;
	public static int GL_IMAGE_BINDING_LAYER;
	public static int GL_IMAGE_BINDING_ACCESS;
	public static int GL_IMAGE_BINDING_FORMAT;
	public static int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT;
	public static int GL_ELEMENT_ARRAY_BARRIER_BIT;
	public static int GL_UNIFORM_BARRIER_BIT;
	public static int GL_TEXTURE_FETCH_BARRIER_BIT;
	public static int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT;
	public static int GL_COMMAND_BARRIER_BIT;
	public static int GL_PIXEL_BUFFER_BARRIER_BIT;
	public static int GL_TEXTURE_UPDATE_BARRIER_BIT;
	public static int GL_BUFFER_UPDATE_BARRIER_BIT;
	public static int GL_FRAMEBUFFER_BARRIER_BIT;
	public static int GL_TRANSFORM_FEEDBACK_BARRIER_BIT;
	public static int GL_ATOMIC_COUNTER_BARRIER_BIT;
	public static int GL_ALL_BARRIER_BITS;
	public static int GL_IMAGE_1D;
	public static int GL_IMAGE_2D;
	public static int GL_IMAGE_3D;
	public static int GL_IMAGE_2D_RECT;
	public static int GL_IMAGE_CUBE;
	public static int GL_IMAGE_BUFFER;
	public static int GL_IMAGE_1D_ARRAY;
	public static int GL_IMAGE_2D_ARRAY;
	public static int GL_IMAGE_CUBE_MAP_ARRAY;
	public static int GL_IMAGE_2D_MULTISAMPLE;
	public static int GL_IMAGE_2D_MULTISAMPLE_ARRAY;
	public static int GL_INT_IMAGE_1D;
	public static int GL_INT_IMAGE_2D;
	public static int GL_INT_IMAGE_3D;
	public static int GL_INT_IMAGE_2D_RECT;
	public static int GL_INT_IMAGE_CUBE;
	public static int GL_INT_IMAGE_BUFFER;
	public static int GL_INT_IMAGE_1D_ARRAY;
	public static int GL_INT_IMAGE_2D_ARRAY;
	public static int GL_INT_IMAGE_CUBE_MAP_ARRAY;
	public static int GL_INT_IMAGE_2D_MULTISAMPLE;
	public static int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY;
	public static int GL_UNSIGNED_INT_IMAGE_1D;
	public static int GL_UNSIGNED_INT_IMAGE_2D;
	public static int GL_UNSIGNED_INT_IMAGE_3D;
	public static int GL_UNSIGNED_INT_IMAGE_2D_RECT;
	public static int GL_UNSIGNED_INT_IMAGE_CUBE;
	public static int GL_UNSIGNED_INT_IMAGE_BUFFER;
	public static int GL_UNSIGNED_INT_IMAGE_1D_ARRAY;
	public static int GL_UNSIGNED_INT_IMAGE_2D_ARRAY;
	public static int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY;
	public static int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE;
	public static int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY;
	public static int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE;
	public static int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE;
	public static int GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS;
	public static int GL_MIN_MAP_BUFFER_ALIGNMENT;
	public static int GL_VERTEX_SHADER_BIT;
	public static int GL_FRAGMENT_SHADER_BIT;
	public static int GL_GEOMETRY_SHADER_BIT;
	public static int GL_TESS_CONTROL_SHADER_BIT;
	public static int GL_TESS_EVALUATION_SHADER_BIT;
	public static int GL_ALL_SHADER_BITS;
	public static int GL_PROGRAM_SEPARABLE;
	public static int GL_ACTIVE_PROGRAM;
	public static int GL_PROGRAM_PIPELINE_BINDING;
	public static int GL_MAX_VIEWPORTS;
	public static int GL_VIEWPORT_SUBPIXEL_BITS;
	public static int GL_VIEWPORT_BOUNDS_RANGE;
	public static int GL_LAYER_PROVOKING_VERTEX;
	public static int GL_VIEWPORT_INDEX_PROVOKING_VERTEX;
	public static int GL_UNDEFINED_VERTEX;
	public static int GL_MULTISAMPLE_LINE_WIDTH_RANGE_ARB;
	public static int GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY_ARB;
	public static int GL_MULTIPLY;
	public static int GL_SCREEN;
	public static int GL_OVERLAY;
	public static int GL_DARKEN;
	public static int GL_LIGHTEN;
	public static int GL_COLORDODGE;
	public static int GL_COLORBURN;
	public static int GL_HARDLIGHT;
	public static int GL_SOFTLIGHT;
	public static int GL_DIFFERENCE;
	public static int GL_EXCLUSION;
	public static int GL_HSL_HUE;
	public static int GL_HSL_SATURATION;
	public static int GL_HSL_COLOR;
	public static int GL_HSL_LUMINOSITY;
	public static int GL_GEOMETRY_LINKED_VERTICES_OUT;
	public static int GL_GEOMETRY_LINKED_INPUT_TYPE;
	public static int GL_GEOMETRY_LINKED_OUTPUT_TYPE;
	public static int GL_PRIMITIVE_BOUNDING_BOX_ARB;
	public static int GL_CONTEXT_ROBUST_ACCESS;
	public static int GL_COMPRESSED_RGBA_ASTC_4x4;
	public static int GL_COMPRESSED_RGBA_ASTC_5x4;
	public static int GL_COMPRESSED_RGBA_ASTC_5x5;
	public static int GL_COMPRESSED_RGBA_ASTC_6x5;
	public static int GL_COMPRESSED_RGBA_ASTC_6x6;
	public static int GL_COMPRESSED_RGBA_ASTC_8x5;
	public static int GL_COMPRESSED_RGBA_ASTC_8x6;
	public static int GL_COMPRESSED_RGBA_ASTC_8x8;
	public static int GL_COMPRESSED_RGBA_ASTC_10x5;
	public static int GL_COMPRESSED_RGBA_ASTC_10x6;
	public static int GL_COMPRESSED_RGBA_ASTC_10x8;
	public static int GL_COMPRESSED_RGBA_ASTC_10x10;
	public static int GL_COMPRESSED_RGBA_ASTC_12x10;
	public static int GL_COMPRESSED_RGBA_ASTC_12x12;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_4x4;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x4;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x5;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x5;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x6;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x5;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x6;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x8;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x5;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x6;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x8;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x10;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x10;
	public static int GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x12;
	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglDeleteRenderbuffers(int arg0,long arg1) {
		WRAPPER.nglDeleteRenderbuffers(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetNamedFramebufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetNamedFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglMultiDrawElementsIndirect(int arg0,int arg1,long arg2,int arg3,int arg4) {
		WRAPPER.nglMultiDrawElementsIndirect(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLightiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos3dv(long arg0) {
		WRAPPER.nglRasterPos3dv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP2ui(int arg0,int arg1) {
		WRAPPER.glVertexP2ui(arg0,arg1);
	}


	/** GL46 */
	public static void glNamedFramebufferParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glNamedFramebufferParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1iv(int arg0,int[] arg1) {
		WRAPPER.glUniform1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform1iv(arg0,arg1);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,double[] arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,long[] arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,float[] arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,short[] arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,int[] arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.FloatBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.DoubleBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.LongBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,long arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferData(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoorddv(double[] arg0) {
		WRAPPER.glFogCoorddv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoorddv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glFogCoorddv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI1uiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindRenderbuffer(int arg0,int arg1) {
		WRAPPER.glBindRenderbuffer(arg0,arg1);
	}


	/** GL46 */
	public static int glGetNamedFramebufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetNamedFramebufferParameteri(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glUseProgramStages(int arg0,int arg1,int arg2) {
		WRAPPER.glUseProgramStages(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos3fv(long arg0) {
		WRAPPER.nglRasterPos3fv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform4uiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform4uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetActiveUniformName(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.nglGetActiveUniformName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglClipPlane(int arg0,long arg1) {
		WRAPPER.nglClipPlane(arg0,arg1);
	}


	/** GL46 */
	public static void glGetQueryBufferObjectiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetQueryBufferObjectiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglVertexAttribL1dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribL1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord1dv(long arg0) {
		WRAPPER.nglTexCoord1dv(arg0);
	}


	/** GL46 */
	public static void nglBindTextures(int arg0,int arg1,long arg2) {
		WRAPPER.nglBindTextures(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPopAttrib() {
		WRAPPER.glPopAttrib();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI4sv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glAccum(int arg0,float arg1) {
		WRAPPER.glAccum(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glShadeModel(int arg0) {
		WRAPPER.glShadeModel(arg0);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static float glGetMultisamplef(int arg0,int arg1) {
		return WRAPPER.glGetMultisamplef(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexP4uiv(int arg0,long arg1) {
		WRAPPER.nglVertexP4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static int glGetTexParameterIi(int arg0,int arg1) {
		return WRAPPER.glGetTexParameterIi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLightfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglLightfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetRenderbufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetRenderbufferParameteri(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.lang.String glGetStringi(int arg0,int arg1) {
		return WRAPPER.glGetStringi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3dv(double[] arg0) {
		WRAPPER.glVertex3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glVertex3dv(arg0);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glTextureParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPolygonStipple(java.nio.ByteBuffer arg0) {
		WRAPPER.glGetPolygonStipple(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPolygonStipple(long arg0) {
		WRAPPER.glGetPolygonStipple(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void nglTexCoordP1uiv(int arg0,long arg1) {
		WRAPPER.nglTexCoordP1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFogCoordfv(long arg0) {
		WRAPPER.nglFogCoordfv(arg0);
	}


	/** GL46 */
	public static void nglGetTransformFeedbacki64_v(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTransformFeedbacki64_v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglClearNamedFramebufferuiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglClearNamedFramebufferuiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnMapfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetnMapfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetnMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetTexEnvi(int arg0,int arg1) {
		return WRAPPER.glGetTexEnvi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2dv(double[] arg0) {
		WRAPPER.glRasterPos2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glRasterPos2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static float glGetTexEnvf(int arg0,int arg1) {
		return WRAPPER.glGetTexEnvf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGenVertexArrays(int[] arg0) {
		WRAPPER.glGenVertexArrays(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGenVertexArrays() {
		return WRAPPER.glGenVertexArrays();
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGenVertexArrays(java.nio.IntBuffer arg0) {
		WRAPPER.glGenVertexArrays(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormalPointer(int arg0,int arg1,long arg2) {
		WRAPPER.nglNormalPointer(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glEnableVertexArrayAttrib(int arg0,int arg1) {
		WRAPPER.glEnableVertexArrayAttrib(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadTransposeMatrixd(double[] arg0) {
		WRAPPER.glLoadTransposeMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadTransposeMatrixd(java.nio.DoubleBuffer arg0) {
		WRAPPER.glLoadTransposeMatrixd(arg0);
	}


	/** GLES30, GL46, GLES32 */
	public static void nglGetProgramBinary(int arg0,int arg1,long arg2,long arg3,long arg4) {
		WRAPPER.nglGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static int glGetTextureParameteri(int arg0,int arg1) {
		return WRAPPER.glGetTextureParameteri(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadTransposeMatrixf(java.nio.FloatBuffer arg0) {
		WRAPPER.glLoadTransposeMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadTransposeMatrixf(float[] arg0) {
		WRAPPER.glLoadTransposeMatrixf(arg0);
	}


	/** GL46 */
	public static int glGetVertexArrayi(int arg0,int arg1) {
		return WRAPPER.glGetVertexArrayi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenFramebuffers(int[] arg0) {
		WRAPPER.glGenFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenFramebuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glGenFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGenFramebuffers() {
		return WRAPPER.glGenFramebuffers();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3fv(float[] arg0) {
		WRAPPER.glVertex3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glVertex3fv(arg0);
	}


	/** GL46 */
	public static float glGetTextureParameterf(int arg0,int arg1) {
		return WRAPPER.glGetTextureParameterf(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,long arg11) {
		WRAPPER.nglGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
	}


	/** GL46 */
	public static void glBindTextureUnit(int arg0,int arg1) {
		WRAPPER.glBindTextureUnit(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniform1dv(int arg0,double[] arg1) {
		WRAPPER.glUniform1dv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniform1dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glUniform1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,float[] arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,double[] arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,int[] arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,short[] arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInterleavedArrays(int arg0,int arg1,long arg2) {
		WRAPPER.glInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glGetProgramResourceiv(int arg0,int arg1,int arg2,int[] arg3,int[] arg4,int[] arg5) {
		WRAPPER.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void glGetProgramResourceiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5) {
		WRAPPER.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void nglGenProgramPipelines(int arg0,long arg1) {
		WRAPPER.nglGenProgramPipelines(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMatrixMode(int arg0) {
		WRAPPER.glMatrixMode(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClientActiveTexture(int arg0) {
		WRAPPER.glClientActiveTexture(arg0);
	}


	/** GL46 */
	public static int glGetTextureParameterIi(int arg0,int arg1) {
		return WRAPPER.glGetTextureParameterIi(arg0,arg1);
	}


	/** GL46 */
	public static float glGetTextureLevelParameterf(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTextureLevelParameterf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniform1uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform1uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetActiveUniformsi(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveUniformsi(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static long glGetVertexAttribPointer(int arg0,int arg1) {
		return WRAPPER.glGetVertexAttribPointer(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int nglGetProgramResourceIndex(int arg0,int arg1,long arg2) {
		return WRAPPER.nglGetProgramResourceIndex(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetTextureLevelParameteri(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTextureLevelParameteri(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnMapdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetnMapdv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnMapdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetnMapdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexEnviv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteVertexArrays(int[] arg0) {
		WRAPPER.glDeleteVertexArrays(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteVertexArrays(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteVertexArrays(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteVertexArrays(int arg0) {
		WRAPPER.glDeleteVertexArrays(arg0);
	}


	/** GL40, GL46 */
	public static void glGetUniformSubroutineuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetUniformSubroutineuiv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glGetUniformSubroutineuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetUniformSubroutineuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetVertexAttribIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetVertexAttribIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glHint(int arg0,int arg1) {
		WRAPPER.glHint(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordfv(float[] arg0) {
		WRAPPER.glFogCoordfv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordfv(java.nio.FloatBuffer arg0) {
		WRAPPER.glFogCoordfv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteFramebuffers(int arg0) {
		WRAPPER.glDeleteFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteFramebuffers(int[] arg0) {
		WRAPPER.glDeleteFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteFramebuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetAttachedShaders(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetAttachedShaders(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1fv(int arg0,float[] arg1) {
		WRAPPER.glUniform1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glUniform1fv(arg0,arg1);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glSamplerParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglScissorIndexedv(int arg0,long arg1) {
		WRAPPER.nglScissorIndexedv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetShaderiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetShaderiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglDebugMessageCallback(long arg0,long arg1) {
		WRAPPER.nglDebugMessageCallback(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetProgrami(int arg0,int arg1) {
		return WRAPPER.glGetProgrami(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBindFragDataLocation(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glBindFragDataLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBindFragDataLocation(int arg0,int arg1,java.lang.CharSequence arg2) {
		WRAPPER.glBindFragDataLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4usv(long arg0) {
		WRAPPER.nglColor4usv(arg0);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void nglGetSamplerParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveUniform_String(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4) {
		return WRAPPER.glGetActiveUniform_String(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetActiveUniform(int arg0,int arg1,int[] arg2,int[] arg3,int[] arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetActiveUniform(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveUniform_String(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		return WRAPPER.glGetActiveUniform_String(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glVertex3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3iv(int[] arg0) {
		WRAPPER.glVertex3iv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3) {
		WRAPPER.glColorMask(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetTextureParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTextureParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirect(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawElementsIndirect(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirect(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawElementsIndirect(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirect(int arg0,int arg1,long arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawElementsIndirect(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirect(int arg0,int arg1,int[] arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawElementsIndirect(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP3ui(int arg0,int arg1,int arg2) {
		WRAPPER.glMultiTexCoordP3ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnviv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetCompressedTexImage(int arg0,int arg1,long arg2) {
		WRAPPER.glGetCompressedTexImage(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetCompressedTexImage(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetCompressedTexImage(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetObjectPtrLabel_String(long arg0) {
		return WRAPPER.glGetObjectPtrLabel_String(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetObjectPtrLabel(long arg0,int[] arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetObjectPtrLabel(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetObjectPtrLabel_String(long arg0,int arg1) {
		return WRAPPER.glGetObjectPtrLabel_String(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glGetObjectPtrLabel(long arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetObjectPtrLabel(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform2uiv(int arg0,int[] arg1) {
		WRAPPER.glUniform2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform2uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform2uiv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix3dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glTextureParameterIui(int arg0,int arg1,int arg2) {
		WRAPPER.glTextureParameterIui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glMultiTexCoord3sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3sv(int arg0,short[] arg1) {
		WRAPPER.glMultiTexCoord3sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glVertexAttrib1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib1fv(int arg0,float[] arg1) {
		WRAPPER.glVertexAttrib1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBindVertexArray(int arg0) {
		WRAPPER.glBindVertexArray(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBeginQuery(int arg0,int arg1) {
		WRAPPER.glBeginQuery(arg0,arg1);
	}


	/** GL46 */
	public static void glGetFloati_v(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetFloati_v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetFloati_v(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetFloati_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex3dv(long arg0) {
		WRAPPER.nglVertex3dv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindTexture(int arg0,int arg1) {
		WRAPPER.glBindTexture(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2iv(int[] arg0) {
		WRAPPER.glRasterPos2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2iv(java.nio.IntBuffer arg0) {
		WRAPPER.glRasterPos2iv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glPolygonOffset(float arg0,float arg1) {
		WRAPPER.glPolygonOffset(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glTexCoord2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2dv(double[] arg0) {
		WRAPPER.glTexCoord2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexMask(int arg0) {
		WRAPPER.glIndexMask(arg0);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static boolean glIsEnabledi(int arg0,int arg1) {
		return WRAPPER.glIsEnabledi(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetnMapfv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnMapfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord3sv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord3sv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int glGetDebugMessageLog(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6) {
		return WRAPPER.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static int glGetDebugMessageLog(int arg0,int[] arg1,int[] arg2,int[] arg3,int[] arg4,int[] arg5,java.nio.ByteBuffer arg6) {
		return WRAPPER.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP3uiv(int arg0,int[] arg1) {
		WRAPPER.glTexCoordP3uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glTexCoordP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttrib1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttrib1dv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6) {
		WRAPPER.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4sv(long arg0) {
		WRAPPER.nglColor4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPolygonStipple(long arg0) {
		WRAPPER.nglPolygonStipple(arg0);
	}


	/** GL40, GL46 */
	public static void nglUniformSubroutinesuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniformSubroutinesuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glWaitSync(long arg0,int arg1,long arg2) {
		WRAPPER.glWaitSync(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glRasterPos2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2fv(float[] arg0) {
		WRAPPER.glRasterPos2fv(arg0);
	}


	/** GL46 */
	public static void nglGetTextureParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEdgeFlagPointer(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glEdgeFlagPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEdgeFlagPointer(int arg0,long arg1) {
		WRAPPER.glEdgeFlagPointer(arg0,arg1);
	}


	/** GL46 */
	public static int glCheckNamedFramebufferStatus(int arg0,int arg1) {
		return WRAPPER.glCheckNamedFramebufferStatus(arg0,arg1);
	}


	/** GL46 */
	public static void glTextureBuffer(int arg0,int arg1,int arg2) {
		WRAPPER.glTextureBuffer(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglGetnMapiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnMapiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnMapiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetnMapiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnMapiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetnMapiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform1uiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform1uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glTexEnvfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnvfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glTexEnvfv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix3dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix3dv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureView(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7) {
		WRAPPER.glTextureView(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1iv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGenQueries(int arg0,long arg1) {
		WRAPPER.nglGenQueries(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2iv(java.nio.IntBuffer arg0) {
		WRAPPER.glTexCoord2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2iv(int[] arg0) {
		WRAPPER.glTexCoord2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex3iv(long arg0) {
		WRAPPER.nglVertex3iv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP1ui(int arg0,int arg1,boolean arg2,int arg3) {
		WRAPPER.glVertexAttribP1ui(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord1fv(long arg0) {
		WRAPPER.nglTexCoord1fv(arg0);
	}


	/** GL46 */
	public static void glNamedFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glNamedFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glDisableVertexArrayAttrib(int arg0,int arg1) {
		WRAPPER.glDisableVertexArrayAttrib(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos3iv(long arg0) {
		WRAPPER.nglRasterPos3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetPixelMapfv(int arg0,long arg1) {
		WRAPPER.nglGetPixelMapfv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glSecondaryColorP3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glSecondaryColorP3uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glSecondaryColorP3uiv(int arg0,int[] arg1) {
		WRAPPER.glSecondaryColorP3uiv(arg0,arg1);
	}


	/** GL46 */
	public static void glTexStorage1D(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glTexStorage1D(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib1dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib1dv(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawArraysIndirect(int arg0,int[] arg1) {
		WRAPPER.glDrawArraysIndirect(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawArraysIndirect(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glDrawArraysIndirect(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawArraysIndirect(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glDrawArraysIndirect(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawArraysIndirect(int arg0,long arg1) {
		WRAPPER.glDrawArraysIndirect(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI4usv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetPointerv(int arg0,org.lwjgl.PointerBuffer arg1) {
		WRAPPER.glGetPointerv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int nglGetUniformLocation(int arg0,long arg1) {
		return WRAPPER.nglGetUniformLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glEndTransformFeedback() {
		WRAPPER.glEndTransformFeedback();
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexAttribP4uiv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglVertexAttribP4uiv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glActiveShaderProgram(int arg0,int arg1) {
		WRAPPER.glActiveShaderProgram(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix3fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix3fv(arg0,arg1,arg2);
	}


	/** GLES30, GL46, GLES32 */
	public static void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetUniformIndices(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetUniformIndices(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetUniformIndices(int arg0,org.lwjgl.PointerBuffer arg1,int[] arg2) {
		WRAPPER.glGetUniformIndices(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetUniformIndices(int arg0,org.lwjgl.PointerBuffer arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetUniformIndices(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetUniformIndices(int arg0,java.lang.CharSequence[] arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetUniformIndices(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long nglGetStringi(int arg0,int arg1) {
		return WRAPPER.nglGetStringi(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glTextureParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static boolean glIsTransformFeedback(int arg0) {
		return WRAPPER.glIsTransformFeedback(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexGeniv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexGeniv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglMultiTexCoordP2uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMultiTexCoordP2uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord1iv(long arg0) {
		WRAPPER.nglTexCoord1iv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawRangeElements(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glDrawRangeElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawRangeElements(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glDrawRangeElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawRangeElements(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glDrawRangeElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix3fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3fv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glDrawTransformFeedbackStreamInstanced(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glDrawTransformFeedbackStreamInstanced(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexAttribL4d(int arg0,double arg1,double arg2,double arg3,double arg4) {
		WRAPPER.glVertexAttribL4d(arg0,arg1,arg2,arg3,arg4);
	}


	/** GLES30, GL46, GLES32 */
	public static void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glWindowPos3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3sv(short[] arg0) {
		WRAPPER.glWindowPos3sv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGenQueries(int[] arg0) {
		WRAPPER.glGenQueries(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGenQueries(java.nio.IntBuffer arg0) {
		WRAPPER.glGenQueries(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGenQueries() {
		return WRAPPER.glGenQueries();
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP2uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexP2uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP2uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexP2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glFlush() {
		WRAPPER.glFlush();
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void nglGetProgramInterfaceiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetProgramInterfaceiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2x4fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix2x4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2x4fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix2x4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex3fv(long arg0) {
		WRAPPER.nglVertex3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2fv(float[] arg0) {
		WRAPPER.glTexCoord2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glTexCoord2fv(arg0);
	}


	/** GL46 */
	public static int glGetTransformFeedbacki(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTransformFeedbacki(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetTransformFeedbacki(int arg0,int arg1) {
		return WRAPPER.glGetTransformFeedbacki(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetnMapdv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnMapdv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTransformFeedbacki64_v(int arg0,int arg1,int arg2,long[] arg3) {
		WRAPPER.glGetTransformFeedbacki64_v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTransformFeedbacki64_v(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3) {
		WRAPPER.glGetTransformFeedbacki64_v(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawElementsBaseVertex(int arg0,java.nio.IntBuffer arg1,int arg2,org.lwjgl.PointerBuffer arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glMultiDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawElementsBaseVertex(int arg0,int[] arg1,int arg2,org.lwjgl.PointerBuffer arg3,int[] arg4) {
		WRAPPER.glMultiDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3x2fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix3x2fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3x2fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix3x2fv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glFlushMappedNamedBufferRange(int arg0,long arg1,long arg2) {
		WRAPPER.glFlushMappedNamedBufferRange(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPrioritizeTextures(int arg0,long arg1,long arg2) {
		WRAPPER.nglPrioritizeTextures(arg0,arg1,arg2);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateFramebuffer(int arg0,int[] arg1) {
		WRAPPER.glInvalidateFramebuffer(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateFramebuffer(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glInvalidateFramebuffer(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateFramebuffer(int arg0,int arg1) {
		WRAPPER.glInvalidateFramebuffer(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP4ui(int arg0,int arg1) {
		WRAPPER.glTexCoordP4ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMaterialfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetMaterialfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetMaterialfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void nglDeleteTransformFeedbacks(int arg0,long arg1) {
		WRAPPER.nglDeleteTransformFeedbacks(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5) {
		WRAPPER.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos2sv(long arg0) {
		WRAPPER.nglRasterPos2sv(arg0);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void nglSamplerParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetTextureParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static long nglMapBuffer(int arg0,int arg1) {
		return WRAPPER.nglMapBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4iv(long arg0) {
		WRAPPER.nglColor4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5) {
		WRAPPER.nglDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexGenfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetTexLevelParameterfv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetMapdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetMapdv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,float[] arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,short[] arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnColorTable(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetnColorTable(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetMultisamplefv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMultisamplefv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4uiv(long arg0) {
		WRAPPER.nglColor4uiv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameterf(int arg0,int arg1,float arg2) {
		WRAPPER.glTexParameterf(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglCreateTextures(int arg0,int arg1,long arg2) {
		WRAPPER.nglCreateTextures(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nbv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttrib4Nbv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoordPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsBuffer(int arg0) {
		return WRAPPER.glIsBuffer(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetUniformuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetUniformuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPrioritizeTextures(java.nio.IntBuffer arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glPrioritizeTextures(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPrioritizeTextures(int[] arg0,float[] arg1) {
		WRAPPER.glPrioritizeTextures(arg0,arg1);
	}


	/** GLES32 */
	public static void glSamplerParameterIui(int arg0,int arg1,int arg2) {
		WRAPPER.glSamplerParameterIui(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glVertexAttribL2dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttribL2dv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexAttribL2dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttribL2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex2iv(long arg0) {
		WRAPPER.nglVertex2iv(arg0);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,int[] arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,short[] arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,java.nio.DoubleBuffer arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,double[] arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,float[] arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,long arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBufferStorage(int arg0,java.nio.FloatBuffer arg1,int arg2) {
		WRAPPER.glBufferStorage(arg0,arg1,arg2);
	}


	/** GL40, GL46, GLES32 */
	public static void glMinSampleShading(float arg0) {
		WRAPPER.glMinSampleShading(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI4bv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4bv(arg0,arg1);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglVertexAttrib1fv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3sv(short[] arg0) {
		WRAPPER.glVertex3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glVertex3sv(arg0);
	}


	/** GL46 */
	public static void nglGetTextureImage(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglGetTextureImage(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glValidateProgram(int arg0) {
		WRAPPER.glValidateProgram(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexGendv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexGendv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadMatrixd(double[] arg0) {
		WRAPPER.glLoadMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadMatrixd(java.nio.DoubleBuffer arg0) {
		WRAPPER.glLoadMatrixd(arg0);
	}


	/** GL46 */
	public static void nglGetnTexImage(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglGetnTexImage(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadMatrixf(java.nio.FloatBuffer arg0) {
		WRAPPER.glLoadMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadMatrixf(float[] arg0) {
		WRAPPER.glLoadMatrixf(arg0);
	}


	/** GL46 */
	public static void glNamedFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glNamedFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglCreateRenderbuffers(int arg0,long arg1) {
		WRAPPER.nglCreateRenderbuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglVertexAttribI4iv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4iv(arg0,arg1);
	}


	/** GL46 */
	public static void nglViewportArrayv(int arg0,int arg1,long arg2) {
		WRAPPER.nglViewportArrayv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglUniform1dv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform1dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDepthRange(double arg0,double arg1) {
		WRAPPER.glDepthRange(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGenTextures(int arg0,long arg1) {
		WRAPPER.nglGenTextures(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetnPixelMapfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetnPixelMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nusv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib4Nusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nusv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib4Nusv(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void glProgramParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glProgramParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform1ui(int arg0,int arg1) {
		WRAPPER.glUniform1ui(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP3ui(int arg0,int arg1) {
		WRAPPER.glColorP3ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static java.nio.ByteBuffer glMapBuffer_ByteBuffer(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glMapBuffer_ByteBuffer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static java.nio.ByteBuffer glMapBuffer_ByteBuffer(int arg0,int arg1) {
		return WRAPPER.glMapBuffer_ByteBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static java.nio.ByteBuffer glMapBuffer_ByteBuffer(int arg0,int arg1,long arg2,java.nio.ByteBuffer arg3) {
		return WRAPPER.glMapBuffer_ByteBuffer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP3uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMultiTexCoordP3uiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP3uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glMultiTexCoordP3uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glClearBufferuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glClearBufferuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglTextureParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGenerateTextureMipmap(int arg0) {
		WRAPPER.glGenerateTextureMipmap(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglVertexAttribI4uiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform1fv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform1fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glTexParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetMapiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMapiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetMapiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetVertexAttribIi(int arg0,int arg1) {
		return WRAPPER.glGetVertexAttribIi(arg0,arg1);
	}


	/** GL46 */
	public static double glGetDoublei(int arg0,int arg1) {
		return WRAPPER.glGetDoublei(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord4dv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord4dv(arg0,arg1);
	}


	/** GL46 */
	public static void glClipControl(int arg0,int arg1) {
		WRAPPER.glClipControl(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetQueryi(int arg0,int arg1) {
		return WRAPPER.glGetQueryi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBindBufferBase(int arg0,int arg1,int arg2) {
		WRAPPER.glBindBufferBase(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetnUniformui(int arg0,int arg1) {
		return WRAPPER.glGetnUniformui(arg0,arg1);
	}


	/** GLES32 */
	public static float glGetnUniformui_float(int arg0,int arg1) {
		return WRAPPER.glGetnUniformui_float(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetDoublev(int arg0,double[] arg1) {
		WRAPPER.glGetDoublev(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetDoublev(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glGetDoublev(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glMultiTexCoord4sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4sv(int arg0,short[] arg1) {
		WRAPPER.glMultiTexCoord4sv(arg0,arg1);
	}


	/** GL46 */
	public static void nglBindVertexBuffers(int arg0,int arg1,long arg2,long arg3,long arg4) {
		WRAPPER.nglBindVertexBuffers(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Niv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttrib4Niv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Niv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttrib4Niv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexArrayVertexBuffer(int arg0,int arg1,int arg2,long arg3,int arg4) {
		WRAPPER.glVertexArrayVertexBuffer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMaterialiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetMaterialiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetMaterialiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetMaterialiv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glListBase(int arg0) {
		WRAPPER.glListBase(arg0);
	}


	/** GL46 */
	public static void nglScissorArrayv(int arg0,int arg1,long arg2) {
		WRAPPER.nglScissorArrayv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glCreateProgram() {
		return WRAPPER.glCreateProgram();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4ubv(long arg0) {
		WRAPPER.nglColor4ubv(arg0);
	}


	/** GL46 */
	public static void nglInvalidateNamedFramebufferData(int arg0,int arg1,long arg2) {
		WRAPPER.nglInvalidateNamedFramebufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetBufferPointerv(int arg0,int arg1,org.lwjgl.PointerBuffer arg2) {
		WRAPPER.glGetBufferPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFeedbackBuffer(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glFeedbackBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFeedbackBuffer(int arg0,float[] arg1) {
		WRAPPER.glFeedbackBuffer(arg0,arg1);
	}


	/** GL46 */
	public static int glGetNamedFramebufferAttachmentParameteri(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetNamedFramebufferAttachmentParameteri(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetCompressedTextureImage(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetCompressedTextureImage(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetCompressedTextureImage(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetCompressedTextureImage(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glProgramUniform3fv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3fv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glProgramUniform3fv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCullFace(int arg0) {
		WRAPPER.glCullFace(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultMatrixd(java.nio.DoubleBuffer arg0) {
		WRAPPER.glMultMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultMatrixd(double[] arg0) {
		WRAPPER.glMultMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.nglCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetBooleani_v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetBooleani_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4dv(int arg0,double[] arg1) {
		WRAPPER.glMultiTexCoord4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glMultiTexCoord4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord4fv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform1iv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform1iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultMatrixf(java.nio.FloatBuffer arg0) {
		WRAPPER.glMultMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultMatrixf(float[] arg0) {
		WRAPPER.glMultMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetDoublev(int arg0,long arg1) {
		WRAPPER.nglGetDoublev(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniformSubroutinesui(int arg0,int arg1) {
		WRAPPER.glUniformSubroutinesui(arg0,arg1);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glDepthRangef(float arg0,float arg1) {
		WRAPPER.glDepthRangef(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDisable(int arg0) {
		WRAPPER.glDisable(arg0);
	}


	/** GLES30, GL46, GLES32 */
	public static void nglProgramBinary(int arg0,int arg1,long arg2,int arg3) {
		WRAPPER.nglProgramBinary(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLightModelfv(int arg0,long arg1) {
		WRAPPER.nglLightModelfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static int glGetActiveAtomicCounterBufferi(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveAtomicCounterBufferi(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4bv(long arg0) {
		WRAPPER.nglColor4bv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightf(int arg0,int arg1,float arg2) {
		WRAPPER.glLightf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex2sv(long arg0) {
		WRAPPER.nglVertex2sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLighti(int arg0,int arg1,int arg2) {
		WRAPPER.glLighti(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static int glGetFramebufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetFramebufferParameteri(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2sv(short[] arg0) {
		WRAPPER.glTexCoord2sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glTexCoord2sv(arg0);
	}


	/** GL46 */
	public static void nglGetVertexArrayIndexed64iv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetVertexArrayIndexed64iv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5,int arg6) {
		WRAPPER.nglDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFogCoorddv(long arg0) {
		WRAPPER.nglFogCoorddv(arg0);
	}


	/** GL46, GLES32 */
	public static int glGetProgramInterfacei(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetProgramInterfacei(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4) {
		WRAPPER.glUniform4f(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGenFramebuffers(int arg0,long arg1) {
		WRAPPER.nglGenFramebuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glMultiTexCoord4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4fv(int arg0,float[] arg1) {
		WRAPPER.glMultiTexCoord4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glUniform4i(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2) {
		WRAPPER.glGetBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static int glGetFragDataIndex(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetFragDataIndex(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static int glGetFragDataIndex(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glGetFragDataIndex(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2dv(double[] arg0) {
		WRAPPER.glEvalCoord2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glEvalCoord2dv(arg0);
	}


	/** GL46 */
	public static void nglMultiDrawArraysIndirectCount(int arg0,long arg1,long arg2,int arg3,int arg4) {
		WRAPPER.nglMultiDrawArraysIndirectCount(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glDebugMessageInsert(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glDebugMessageInsert(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glDebugMessageInsert(int arg0,int arg1,int arg2,int arg3,java.lang.CharSequence arg4) {
		WRAPPER.glDebugMessageInsert(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glProgramUniform3dv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glProgramUniform3dv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniform3dv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glProgramUniform3dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPopClientAttrib() {
		WRAPPER.glPopClientAttrib();
	}


	/** GL46 */
	public static void nglGetnCompressedTexImage(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnCompressedTexImage(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform2iv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform2iv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirectCount(int arg0,int[] arg1,long arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawArraysIndirectCount(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirectCount(int arg0,java.nio.IntBuffer arg1,long arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawArraysIndirectCount(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirectCount(int arg0,java.nio.ByteBuffer arg1,long arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawArraysIndirectCount(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirectCount(int arg0,long arg1,long arg2,int arg3,int arg4) {
		WRAPPER.glMultiDrawArraysIndirectCount(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteRenderbuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteRenderbuffers(int arg0) {
		WRAPPER.glDeleteRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteRenderbuffers(int[] arg0) {
		WRAPPER.glDeleteRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1ui(int arg0,int arg1) {
		WRAPPER.glVertexAttribI1ui(arg0,arg1);
	}


	/** GLES32 */
	public static void glSamplerParameterIi(int arg0,int arg1,int arg2) {
		WRAPPER.glSamplerParameterIi(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglPatchParameterfv(int arg0,long arg1) {
		WRAPPER.nglPatchParameterfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPushClientAttrib(int arg0) {
		WRAPPER.glPushClientAttrib(arg0);
	}


	/** GL46 */
	public static void nglBindSamplers(int arg0,int arg1,long arg2) {
		WRAPPER.nglBindSamplers(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long nglMapBufferRange(int arg0,long arg1,long arg2,int arg3) {
		return WRAPPER.nglMapBufferRange(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexEnvfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetTexEnvfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetTexEnvfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nuiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttrib4Nuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nuiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttrib4Nuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4dv(long arg0) {
		WRAPPER.nglColor4dv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static int nglGetFragDataIndex(int arg0,long arg1) {
		return WRAPPER.nglGetFragDataIndex(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetProgramiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetProgramiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetProgramiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLightModeliv(int arg0,long arg1) {
		WRAPPER.nglLightModeliv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,long arg4,long arg5) {
		WRAPPER.nglGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPixelMapusv(int arg0,int arg1,long arg2) {
		WRAPPER.nglPixelMapusv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform2fv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClipPlane(int arg0,double[] arg1) {
		WRAPPER.glClipPlane(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClipPlane(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glClipPlane(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform4uiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform4uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glEvalCoord2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2fv(float[] arg0) {
		WRAPPER.glEvalCoord2fv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenTextures(int[] arg0) {
		WRAPPER.glGenTextures(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenTextures(java.nio.IntBuffer arg0) {
		WRAPPER.glGenTextures(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGenTextures() {
		return WRAPPER.glGenTextures();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSelectBuffer(int arg0,long arg1) {
		WRAPPER.nglSelectBuffer(arg0,arg1);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int[] arg3) {
		WRAPPER.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static int glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2) {
		return WRAPPER.glGetShaderPrecisionFormat(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4iv(int arg0,int[] arg1) {
		WRAPPER.glMultiTexCoord4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glMultiTexCoord4iv(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLineStipple(int arg0,short arg1) {
		WRAPPER.glLineStipple(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glPopDebugGroup() {
		WRAPPER.glPopDebugGroup();
	}


	/** GL40, GL46 */
	public static void glGetProgramStageiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetProgramStageiv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glGetProgramStageiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetProgramStageiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetDoublei_v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetDoublei_v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,double[] arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,float[] arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int[] arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,short[] arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.DoubleBuffer arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.FloatBuffer arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.IntBuffer arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ShortBuffer arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ByteBuffer arg10) {
		WRAPPER.glTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI3uiv(arg0,arg1);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,double[] arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.DoubleBuffer arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1sv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib1sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib1sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEdgeFlag(boolean arg0) {
		WRAPPER.glEdgeFlag(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMaterialf(int arg0,int arg1,float arg2) {
		WRAPPER.glMaterialf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord4iv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMateriali(int arg0,int arg1,int arg2) {
		WRAPPER.glMateriali(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnUniformiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetnUniformiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetnUniformiv(arg0,arg1,arg2);
	}


	/** GLES32 */
	public static void glGetnUniformiv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetnUniformiv(arg0,arg1,arg2);
	}


	/** GLES32 */
	public static void glGetnUniformiv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetnUniformiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor4fv(long arg0) {
		WRAPPER.nglColor4fv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjectui64v(int arg0,int arg1,long arg2) {
		WRAPPER.glGetQueryObjectui64v(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2) {
		WRAPPER.glGetQueryObjectui64v(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetQueryObjectui64v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedRenderbufferStorage(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glNamedRenderbufferStorage(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetTexLevelParameteriv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,short[] arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,double[] arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,float[] arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int[] arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ShortBuffer arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.IntBuffer arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ByteBuffer arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.DoubleBuffer arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.FloatBuffer arg8) {
		WRAPPER.glTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46, GLES32 */
	public static void glDebugMessageControl(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,boolean arg4) {
		WRAPPER.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glDebugMessageControl(int arg0,int arg1,int arg2,int[] arg3,boolean arg4) {
		WRAPPER.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glDebugMessageControl(int arg0,int arg1,int arg2,int arg3,boolean arg4) {
		WRAPPER.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib1sv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib1sv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glDeleteProgramPipelines(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteProgramPipelines(arg0);
	}


	/** GL46, GLES32 */
	public static void glDeleteProgramPipelines(int[] arg0) {
		WRAPPER.glDeleteProgramPipelines(arg0);
	}


	/** GL46, GLES32 */
	public static void glDeleteProgramPipelines(int arg0) {
		WRAPPER.glDeleteProgramPipelines(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformBlockName(int arg0,int arg1,int[] arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveUniformBlockName_String(int arg0,int arg1) {
		return WRAPPER.glGetActiveUniformBlockName_String(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformBlockName(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveUniformBlockName_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveUniformBlockName_String(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCallList(int arg0) {
		WRAPPER.glCallList(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetClipPlane(int arg0,double[] arg1) {
		WRAPPER.glGetClipPlane(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetClipPlane(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glGetClipPlane(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFogiv(int arg0,long arg1) {
		WRAPPER.nglFogiv(arg0,arg1);
	}


	/** GL46 */
	public static int glGetNamedRenderbufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetNamedRenderbufferParameteri(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3iv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform3iv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform3iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsProgram(int arg0) {
		return WRAPPER.glIsProgram(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL40, GL46 */
	public static int glGetActiveSubroutineUniformi(int arg0,int arg1,int arg2,int arg3) {
		return WRAPPER.glGetActiveSubroutineUniformi(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glInvalidateTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7) {
		WRAPPER.glInvalidateTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI4ubv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI4ubv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetProgramInfoLog(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetProgramInfoLog(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,double[] arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.DoubleBuffer arg6) {
		WRAPPER.glTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetProgramPipelineInfoLog_String(int arg0,int arg1) {
		return WRAPPER.glGetProgramPipelineInfoLog_String(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetProgramPipelineInfoLog_String(int arg0) {
		return WRAPPER.glGetProgramPipelineInfoLog_String(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetProgramPipelineInfoLog(int arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetProgramPipelineInfoLog(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glGetProgramPipelineInfoLog(int arg0,int[] arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetProgramPipelineInfoLog(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglTransformFeedbackVaryings(int arg0,int arg1,long arg2,int arg3) {
		WRAPPER.nglTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglProgramUniform2dv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos4fv(long arg0) {
		WRAPPER.nglRasterPos4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord2dv(long arg0) {
		WRAPPER.nglTexCoord2dv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetSynci(long arg0,int arg1,java.nio.IntBuffer arg2) {
		return WRAPPER.glGetSynci(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static boolean glIsVertexArray(int arg0) {
		return WRAPPER.glIsVertexArray(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnvf(int arg0,int arg1,float arg2) {
		WRAPPER.glTexEnvf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexEnvi(int arg0,int arg1,int arg2) {
		WRAPPER.glTexEnvi(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3ubv(long arg0) {
		WRAPPER.nglSecondaryColor3ubv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglDrawElements(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglDrawElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogi(int arg0,int arg1) {
		WRAPPER.glFogi(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.glGetnMinmax(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetnMinmax(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long glFenceSync(int arg0,int arg1) {
		return WRAPPER.glFenceSync(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glClearBufferfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glClearBufferfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindAttribLocation(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glBindAttribLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindAttribLocation(int arg0,int arg1,java.lang.CharSequence arg2) {
		WRAPPER.glBindAttribLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glLightfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glLightfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3b(byte arg0,byte arg1,byte arg2) {
		WRAPPER.glNormal3b(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3d(double arg0,double arg1,double arg2) {
		WRAPPER.glNormal3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetTexParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3f(float arg0,float arg1,float arg2) {
		WRAPPER.glNormal3f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferfi(int arg0,int arg1,float arg2,int arg3) {
		WRAPPER.glClearBufferfi(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord2iv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogf(int arg0,float arg1) {
		WRAPPER.glFogf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglTexParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModeli(int arg0,int arg1) {
		WRAPPER.glLightModeli(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3) {
		WRAPPER.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFogfv(int arg0,long arg1) {
		WRAPPER.nglFogfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1iv(int[] arg0) {
		WRAPPER.glTexCoord1iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1iv(java.nio.IntBuffer arg0) {
		WRAPPER.glTexCoord1iv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glClearBufferiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glClearBufferiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glCopyNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4) {
		WRAPPER.glCopyNamedBufferSubData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL40, GL46 */
	public static void nglColorP3uiv(int arg0,long arg1) {
		WRAPPER.nglColorP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord2fv(long arg0) {
		WRAPPER.nglTexCoord2fv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform3uiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform3uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3i(int arg0,int arg1,int arg2) {
		WRAPPER.glNormal3i(arg0,arg1,arg2);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glDeleteTransformFeedbacks(int[] arg0) {
		WRAPPER.glDeleteTransformFeedbacks(arg0);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glDeleteTransformFeedbacks(int arg0) {
		WRAPPER.glDeleteTransformFeedbacks(arg0);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glDeleteTransformFeedbacks(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteTransformFeedbacks(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos4iv(long arg0) {
		WRAPPER.nglRasterPos4iv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDeleteSync(long arg0) {
		WRAPPER.nglDeleteSync(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetBufferPointerv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetBufferPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglSecondaryColorP3uiv(int arg0,long arg1) {
		WRAPPER.nglSecondaryColorP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglTexParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3s(short arg0,short arg1,short arg2) {
		WRAPPER.glNormal3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPolygonMode(int arg0,int arg1) {
		WRAPPER.glPolygonMode(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.ByteBuffer arg7) {
		WRAPPER.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,long arg6) {
		WRAPPER.nglBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModelf(int arg0,float arg1) {
		WRAPPER.glLightModelf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glSampleMaski(int arg0,int arg1) {
		WRAPPER.glSampleMaski(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,int[] arg3) {
		WRAPPER.glVertexAttribP4uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glVertexAttribP4uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetLighti(int arg0,int arg1) {
		return WRAPPER.glGetLighti(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static float glGetLightf(int arg0,int arg1) {
		return WRAPPER.glGetLightf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIui(int arg0,int arg1,int arg2) {
		WRAPPER.glTexParameterIui(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTextureParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetTextureParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTextureParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetTextureParameterfv(arg0,arg1,arg2);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateSubFramebuffer(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateSubFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GLES30, GL46, GLES32 */
	public static void glInvalidateSubFramebuffer(int arg0,int[] arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4sv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib4sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib4sv(arg0,arg1);
	}


	/** GL46 */
	public static void glBindVertexBuffers(int arg0,int[] arg1,org.lwjgl.PointerBuffer arg2,int[] arg3) {
		WRAPPER.glBindVertexBuffers(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glBindVertexBuffers(int arg0,java.nio.IntBuffer arg1,org.lwjgl.PointerBuffer arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glBindVertexBuffers(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4bv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttribI4bv(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glBindProgramPipeline(int arg0) {
		WRAPPER.glBindProgramPipeline(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetMaterialiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMaterialiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsInstancedBaseVertex(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsInstancedBaseVertex(int arg0,java.nio.ByteBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsInstancedBaseVertex(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3,int arg4) {
		WRAPPER.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsInstancedBaseVertex(int arg0,java.nio.ShortBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glCreateQueries(int arg0,int[] arg1) {
		WRAPPER.glCreateQueries(arg0,arg1);
	}


	/** GL46 */
	public static int glCreateQueries(int arg0) {
		return WRAPPER.glCreateQueries(arg0);
	}


	/** GL46 */
	public static void glCreateQueries(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glCreateQueries(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglDrawElementsBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4) {
		WRAPPER.nglDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexf(float arg0) {
		WRAPPER.glIndexf(arg0);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexi(int arg0) {
		WRAPPER.glIndexi(arg0);
	}


	/** GL46 */
	public static void glCreateTransformFeedbacks(int[] arg0) {
		WRAPPER.glCreateTransformFeedbacks(arg0);
	}


	/** GL46 */
	public static void glCreateTransformFeedbacks(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateTransformFeedbacks(arg0);
	}


	/** GL46 */
	public static int glCreateTransformFeedbacks() {
		return WRAPPER.glCreateTransformFeedbacks();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4bv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4bv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetVertexAttribPointerv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglTexCoordP4uiv(int arg0,long arg1) {
		WRAPPER.nglTexCoordP4uiv(arg0,arg1);
	}


	/** GL46 */
	public static void glProgramUniform4d(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5) {
		WRAPPER.glProgramUniform4d(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5) {
		WRAPPER.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexd(double arg0) {
		WRAPPER.glIndexd(arg0);
	}


	/** GL46, GLES32 */
	public static void nglDeleteProgramPipelines(int arg0,long arg1) {
		WRAPPER.nglDeleteProgramPipelines(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3sv(short[] arg0) {
		WRAPPER.glNormal3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glNormal3sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glEnableVertexAttribArray(int arg0) {
		WRAPPER.glEnableVertexAttribArray(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglTexParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2dv(double[] arg0) {
		WRAPPER.glVertex2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glVertex2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexGendv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexGendv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglPushDebugGroup(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglPushDebugGroup(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexs(short arg0) {
		WRAPPER.glIndexs(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetIntegerv(int arg0,long arg1) {
		WRAPPER.nglGetIntegerv(arg0,arg1);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glClearBufferData(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static int nglGetProgramResourceLocationIndex(int arg0,int arg1,long arg2) {
		return WRAPPER.nglGetProgramResourceLocationIndex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glClear(int arg0) {
		WRAPPER.glClear(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Niv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Niv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.ByteBuffer arg9) {
		WRAPPER.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4) {
		WRAPPER.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGenBuffers(int arg0,long arg1) {
		WRAPPER.nglGenBuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glReadBuffer(int arg0) {
		WRAPPER.glReadBuffer(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos4dv(long arg0) {
		WRAPPER.nglRasterPos4dv(arg0);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform2uiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform2uiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glDispatchComputeIndirect(long arg0) {
		WRAPPER.glDispatchComputeIndirect(arg0);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3) {
		WRAPPER.glProgramUniform2f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadName(int arg0) {
		WRAPPER.glLoadName(arg0);
	}


	/** GL46 */
	public static void glGetTextureParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTextureParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glProgramUniform2i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void nglSamplerParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglGetProgramResourceName(int arg0,int arg1,int arg2,int arg3,long arg4,long arg5) {
		WRAPPER.nglGetProgramResourceName(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glProgramUniform2d(int arg0,int arg1,double arg2,double arg3) {
		WRAPPER.glProgramUniform2d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawBuffer(int arg0) {
		WRAPPER.glDrawBuffer(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetQueryObjectuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetQueryObjectuiv(int arg0,int arg1,long arg2) {
		WRAPPER.glGetQueryObjectuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetQueryObjectuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Nusv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Nusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glVertex2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2fv(float[] arg0) {
		WRAPPER.glVertex2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetMaterialfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMaterialfv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4) {
		WRAPPER.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenRenderbuffers(int[] arg0) {
		WRAPPER.glGenRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenRenderbuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glGenRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGenRenderbuffers() {
		return WRAPPER.glGenRenderbuffers();
	}


	/** GL46 */
	public static void glProgramUniform3d(int arg0,int arg1,double arg2,double arg3,double arg4) {
		WRAPPER.glProgramUniform3d(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDrawElementsInstanced(int arg0,int arg1,int arg2,long arg3,int arg4) {
		WRAPPER.nglDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglClearBufferfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglClearBufferfv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexAttribP3uiv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglVertexAttribP3uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCompileShader(int arg0) {
		WRAPPER.glCompileShader(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int nglGetUniformBlockIndex(int arg0,long arg1) {
		return WRAPPER.nglGetUniformBlockIndex(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetInteger64v(int arg0,long arg1) {
		WRAPPER.nglGetInteger64v(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void nglGetnUniformfv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnUniformfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsRenderbuffer(int arg0) {
		return WRAPPER.glIsRenderbuffer(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix4fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglVertexAttrib4fv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4fv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glProgramUniform2ui(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4ubv(java.nio.ByteBuffer arg0) {
		WRAPPER.glColor4ubv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex4fv(long arg0) {
		WRAPPER.nglVertex4fv(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetProgramResourceName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glGetProgramResourceName(int arg0,int arg1,int arg2,int[] arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetProgramResourceName_String(int arg0,int arg1,int arg2,int arg3) {
		return WRAPPER.glGetProgramResourceName_String(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetProgramResourceName_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetProgramResourceName_String(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glUniform4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4fv(int arg0,float[] arg1) {
		WRAPPER.glUniform4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3uiv(long arg0) {
		WRAPPER.nglSecondaryColor3uiv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glViewport(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glViewport(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglDeleteFramebuffers(int arg0,long arg1) {
		WRAPPER.nglDeleteFramebuffers(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void nglDrawElementsIndirect(int arg0,int arg1,long arg2) {
		WRAPPER.nglDrawElementsIndirect(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix4dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix4dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos3sv(long arg0) {
		WRAPPER.nglWindowPos3sv(arg0);
	}


	/** GL40, GL46, GLES32 */
	public static void nglDrawArraysIndirect(int arg0,long arg1) {
		WRAPPER.nglDrawArraysIndirect(arg0,arg1);
	}


	/** GL46 */
	public static void glBindBuffersRange(int arg0,int arg1,int[] arg2,org.lwjgl.PointerBuffer arg3,org.lwjgl.PointerBuffer arg4) {
		WRAPPER.glBindBuffersRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glBindBuffersRange(int arg0,int arg1,java.nio.IntBuffer arg2,org.lwjgl.PointerBuffer arg3,org.lwjgl.PointerBuffer arg4) {
		WRAPPER.glBindBuffersRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetMapfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniform4uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform4uiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glShaderStorageBlockBinding(int arg0,int arg1,int arg2) {
		WRAPPER.glShaderStorageBlockBinding(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2iv(int[] arg0) {
		WRAPPER.glVertex2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2iv(java.nio.IntBuffer arg0) {
		WRAPPER.glVertex2iv(arg0);
	}


	/** GL46 */
	public static int glCreateBuffers() {
		return WRAPPER.glCreateBuffers();
	}


	/** GL46 */
	public static void glCreateBuffers(int[] arg0) {
		WRAPPER.glCreateBuffers(arg0);
	}


	/** GL46 */
	public static void glCreateBuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetActiveUniform(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5,long arg6) {
		WRAPPER.nglGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetUniformiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetUniformiv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglGetUniformSubroutineuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetUniformSubroutineuiv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glBeginQueryIndexed(int arg0,int arg1,int arg2) {
		WRAPPER.glBeginQueryIndexed(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform4iv(int arg0,int[] arg1) {
		WRAPPER.glUniform4iv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP4ui(int arg0,int arg1,boolean arg2,int arg3) {
		WRAPPER.glVertexAttribP4ui(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglCreateFramebuffers(int arg0,long arg1) {
		WRAPPER.nglCreateFramebuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4iv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI4iv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP2ui(int arg0,int arg1,int arg2) {
		WRAPPER.glMultiTexCoordP2ui(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetnUniformdv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnUniformdv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglBindBuffersRange(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5) {
		WRAPPER.nglBindBuffersRange(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetVertexAttribIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2sv(int arg0,short[] arg1) {
		WRAPPER.glMultiTexCoord2sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glMultiTexCoord2sv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix4dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long glGetInteger64(int arg0) {
		return WRAPPER.glGetInteger64(arg0);
	}


	/** GL46 */
	public static void glClearNamedFramebufferuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glClearNamedFramebufferuiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glClearNamedFramebufferuiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glClearNamedFramebufferuiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDepthMask(boolean arg0) {
		WRAPPER.glDepthMask(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void nglMultiTexCoordP3uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMultiTexCoordP3uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex4dv(long arg0) {
		WRAPPER.nglVertex4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEdgeFlagPointer(int arg0,long arg1) {
		WRAPPER.nglEdgeFlagPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexGenfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetBufferParameteri64v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUseProgram(int arg0) {
		WRAPPER.glUseProgram(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix4fv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static int glGetUniformSubroutineui(int arg0,int arg1) {
		return WRAPPER.glGetUniformSubroutineui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord2sv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord2sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetMapdv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMapdv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglVertexAttribL2dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribL2dv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void nglGetQueryObjectui64v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetQueryObjectui64v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3sv(long arg0) {
		WRAPPER.nglColor3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,double[] arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.DoubleBuffer arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void nglNamedFramebufferDrawBuffers(int arg0,int arg1,long arg2) {
		WRAPPER.nglNamedFramebufferDrawBuffers(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glCreateSamplers() {
		return WRAPPER.glCreateSamplers();
	}


	/** GL46 */
	public static void glCreateSamplers(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateSamplers(arg0);
	}


	/** GL46 */
	public static void glCreateSamplers(int[] arg0) {
		WRAPPER.glCreateSamplers(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPushMatrix() {
		WRAPPER.glPushMatrix();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord2iv(long arg0) {
		WRAPPER.nglTexCoord2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetMapiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetMapiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP4uiv(int arg0,int[] arg1) {
		WRAPPER.glTexCoordP4uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glTexCoordP4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetUniformfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetUniformfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Nbv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Nbv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2x3fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix2x3fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2x3fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix2x3fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glSampleCoverage(float arg0,boolean arg1) {
		WRAPPER.glSampleCoverage(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglClearBufferiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglClearBufferiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glTexCoord1fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1fv(float[] arg0) {
		WRAPPER.glTexCoord1fv(arg0);
	}


	/** GL46 */
	public static void nglCreateQueries(int arg0,int arg1,long arg2) {
		WRAPPER.nglCreateQueries(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,short[] arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int[] arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ShortBuffer arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.IntBuffer arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.FloatBuffer arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.DoubleBuffer arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,float[] arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,double[] arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ByteBuffer arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteShader(int arg0) {
		WRAPPER.glDeleteShader(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform3uiv(int arg0,int[] arg1) {
		WRAPPER.glUniform3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform3uiv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void nglGetnUniformiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnUniformiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttrib4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4iv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttrib4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4iv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glVertexAttrib4fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib4fv(int arg0,float[] arg1) {
		WRAPPER.glVertexAttrib4fv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetNamedBufferPointerv(int arg0,int arg1,org.lwjgl.PointerBuffer arg2) {
		WRAPPER.glGetNamedBufferPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetShaderInfoLog(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetShaderInfoLog(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI1iv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexGeniv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexGeniv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawArrays(int arg0,int arg1,int arg2) {
		WRAPPER.glDrawArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex4iv(long arg0) {
		WRAPPER.nglVertex4iv(arg0);
	}


	/** GL46 */
	public static void glScissorIndexed(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glScissorIndexed(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,float[] arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int[] arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.FloatBuffer arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,short[] arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ByteBuffer arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ShortBuffer arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.IntBuffer arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.DoubleBuffer arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,double[] arg10) {
		WRAPPER.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glCreateTextures(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glCreateTextures(arg0,arg1);
	}


	/** GL46 */
	public static int glCreateTextures(int arg0) {
		return WRAPPER.glCreateTextures(arg0);
	}


	/** GL46 */
	public static void glCreateTextures(int arg0,int[] arg1) {
		WRAPPER.glCreateTextures(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int nglCreateShaderProgramv(int arg0,int arg1,long arg2) {
		return WRAPPER.nglCreateShaderProgramv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglGetUniformdv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetUniformdv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glSamplerParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameterf(int arg0,int arg1,float arg2) {
		WRAPPER.glSamplerParameterf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetActiveUniformsiv(int arg0,int arg1,long arg2,int arg3,long arg4) {
		WRAPPER.nglGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2x3dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix2x3dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2x3dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix2x3dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDeleteVertexArrays(int arg0,long arg1) {
		WRAPPER.nglDeleteVertexArrays(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glRenderMode(int arg0) {
		return WRAPPER.glRenderMode(arg0);
	}


	/** GL40, GL46 */
	public static void glDrawTransformFeedbackStream(int arg0,int arg1,int arg2) {
		WRAPPER.glDrawTransformFeedbackStream(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetFloati_v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetFloati_v(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniform4dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glUniform4dv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniform4dv(int arg0,double[] arg1) {
		WRAPPER.glUniform4dv(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void nglInvalidateFramebuffer(int arg0,int arg1,long arg2) {
		WRAPPER.nglInvalidateFramebuffer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1dv(double[] arg0) {
		WRAPPER.glTexCoord1dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glTexCoord1dv(arg0);
	}


	/** GL40, GL46 */
	public static void glEndQueryIndexed(int arg0,int arg1) {
		WRAPPER.glEndQueryIndexed(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglShaderSource(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglShaderSource(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNewList(int arg0,int arg1) {
		WRAPPER.glNewList(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttribI4sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4sv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttribI4sv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetNamedRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetNamedRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedRenderbufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetNamedRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.DoubleBuffer arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,double[] arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static int nglGetSubroutineIndex(int arg0,int arg1,long arg2) {
		return WRAPPER.nglGetSubroutineIndex(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexAttribL1dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttribL1dv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexAttribL1dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttribL1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFramebufferTexture1D(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glFramebufferTexture1D(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPassThrough(float arg0) {
		WRAPPER.glPassThrough(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapfv(int arg0,float[] arg1) {
		WRAPPER.glPixelMapfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glPixelMapfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapfv(int arg0,int arg1,long arg2) {
		WRAPPER.glPixelMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6) {
		WRAPPER.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glVertexAttribL2d(int arg0,double arg1,double arg2) {
		WRAPPER.glVertexAttribL2d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord1sv(long arg0) {
		WRAPPER.nglTexCoord1sv(arg0);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglClearBufferuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglClearBufferuiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexPointer(int arg0,int arg1,long arg2) {
		WRAPPER.nglIndexPointer(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2x4dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix2x4dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2x4dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix2x4dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glVertexAttribL3d(int arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glVertexAttribL3d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int nglGetAttribLocation(int arg0,long arg1) {
		return WRAPPER.nglGetAttribLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glFlushMappedBufferRange(int arg0,long arg1,long arg2) {
		WRAPPER.glFlushMappedBufferRange(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3x2dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix3x2dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3x2dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix3x2dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilOp(int arg0,int arg1,int arg2) {
		WRAPPER.glStencilOp(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static float glGetUniformf(int arg0,int arg1) {
		return WRAPPER.glGetUniformf(arg0,arg1);
	}


	/** GL40, GL46 */
	public static double glGetUniformd(int arg0,int arg1) {
		return WRAPPER.glGetUniformd(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetUniformi(int arg0,int arg1) {
		return WRAPPER.glGetUniformi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindBuffer(int arg0,int arg1) {
		WRAPPER.glBindBuffer(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniform2dv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform2dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP3ui(int arg0,int arg1) {
		WRAPPER.glTexCoordP3ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTransformFeedbackVaryings(int arg0,java.lang.CharSequence arg1,int arg2) {
		WRAPPER.glTransformFeedbackVaryings(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTransformFeedbackVaryings(int arg0,java.lang.CharSequence[] arg1,int arg2) {
		WRAPPER.glTransformFeedbackVaryings(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTransformFeedbackVaryings(int arg0,org.lwjgl.PointerBuffer arg1,int arg2) {
		WRAPPER.glTransformFeedbackVaryings(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsTexture(int arg0) {
		return WRAPPER.glIsTexture(arg0);
	}


	/** GL46 */
	public static int glGetnMapi(int arg0,int arg1) {
		return WRAPPER.glGetnMapi(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP4uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMultiTexCoordP4uiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP4uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glMultiTexCoordP4uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4uiv(int[] arg0) {
		WRAPPER.glColor4uiv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4uiv(java.nio.IntBuffer arg0) {
		WRAPPER.glColor4uiv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormalPointer(int arg0,int arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glNormalPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormalPointer(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glNormalPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormalPointer(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glNormalPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormalPointer(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glNormalPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormalPointer(int arg0,int arg1,long arg2) {
		WRAPPER.glNormalPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glScalef(float arg0,float arg1,float arg2) {
		WRAPPER.glScalef(arg0,arg1,arg2);
	}


	/** GL46 */
	public static double glGetnMapd(int arg0,int arg1) {
		return WRAPPER.glGetnMapd(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3iv(long arg0) {
		WRAPPER.nglColor3iv(arg0);
	}


	/** GL46 */
	public static float glGetnMapf(int arg0,int arg1) {
		return WRAPPER.glGetnMapf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glScaled(double arg0,double arg1,double arg2) {
		WRAPPER.glScaled(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.nglTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4sv(short[] arg0) {
		WRAPPER.glRasterPos4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glRasterPos4sv(arg0);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetNamedBufferParameteri64v(int arg0,int arg1,long[] arg2) {
		WRAPPER.glGetNamedBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetNamedBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglTextureParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTextureParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglMultiDrawElementsIndirectCount(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5) {
		WRAPPER.nglMultiDrawElementsIndirectCount(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBegin(int arg0) {
		WRAPPER.glBegin(arg0);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glEnable(int arg0) {
		WRAPPER.glEnable(arg0);
	}


	/** GL46 */
	public static void glVertexAttribL1d(int arg0,double arg1) {
		WRAPPER.glVertexAttribL1d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform2fv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform2fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4sv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4sv(arg0,arg1);
	}


	/** GL46 */
	public static int glGetVertexArrayIndexedi(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetVertexArrayIndexedi(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglTextureParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.glTextureBufferRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static float glGetTexGenf(int arg0,int arg1) {
		return WRAPPER.glGetTexGenf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetTexGeni(int arg0,int arg1) {
		return WRAPPER.glGetTexGeni(arg0,arg1);
	}


	/** GL40, GL46 */
	public static int glGetQueryIndexedi(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetQueryIndexedi(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglTextureParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTextureParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordf(float arg0) {
		WRAPPER.glFogCoordf(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetFloatv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glGetFloatv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetFloatv(int arg0,float[] arg1) {
		WRAPPER.glGetFloatv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordd(double arg0) {
		WRAPPER.glFogCoordd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static double glGetTexGend(int arg0,int arg1) {
		return WRAPPER.glGetTexGend(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void nglNormalP3uiv(int arg0,long arg1) {
		WRAPPER.nglNormalP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glVertex2sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2sv(short[] arg0) {
		WRAPPER.glVertex2sv(arg0);
	}


	/** GL46 */
	public static float glGetFloati(int arg0,int arg1) {
		return WRAPPER.glGetFloati(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDrawBuffers(int arg0,long arg1) {
		WRAPPER.nglDrawBuffers(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseInstance(int arg0,java.nio.ShortBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseInstance(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseInstance(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3,int arg4) {
		WRAPPER.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseInstance(int arg0,java.nio.ByteBuffer arg1,int arg2,int arg3) {
		WRAPPER.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglInvalidateNamedFramebufferSubData(int arg0,int arg1,long arg2,int arg3,int arg4,int arg5,int arg6) {
		WRAPPER.nglInvalidateNamedFramebufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPolygonStipple(long arg0) {
		WRAPPER.glPolygonStipple(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPolygonStipple(java.nio.ByteBuffer arg0) {
		WRAPPER.glPolygonStipple(arg0);
	}


	/** GL46 */
	public static void nglNamedBufferData(int arg0,long arg1,long arg2,int arg3) {
		WRAPPER.nglNamedBufferData(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glFrontFace(int arg0) {
		WRAPPER.glFrontFace(arg0);
	}


	/** GL46, GLES32 */
	public static void glDispatchCompute(int arg0,int arg1,int arg2) {
		WRAPPER.glDispatchCompute(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglTexParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glAlphaFunc(int arg0,float arg1) {
		WRAPPER.glAlphaFunc(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos3sv(long arg0) {
		WRAPPER.nglRasterPos3sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform2iv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform2iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetVertexAttribIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearNamedBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glClearNamedBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void nglGetNamedBufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetNamedBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGenLists(int arg0) {
		return WRAPPER.glGenLists(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3usv(long arg0) {
		WRAPPER.nglSecondaryColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectsv(short[] arg0,short[] arg1) {
		WRAPPER.glRectsv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectsv(java.nio.ShortBuffer arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glRectsv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetActiveUniformBlocki(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveUniformBlocki(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetFramebufferAttachmentParameteri(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetFramebufferAttachmentParameteri(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glBindVertexBuffer(int arg0,int arg1,long arg2,int arg3) {
		WRAPPER.glBindVertexBuffer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTexParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glVertexAttribBinding(int arg0,int arg1) {
		WRAPPER.glVertexAttribBinding(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Nubv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Nubv(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP1uiv(int arg0,int[] arg1) {
		WRAPPER.glTexCoordP1uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP1uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glTexCoordP1uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glSecondaryColorP3ui(int arg0,int arg1) {
		WRAPPER.glSecondaryColorP3ui(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int glGenProgramPipelines() {
		return WRAPPER.glGenProgramPipelines();
	}


	/** GL46, GLES32 */
	public static void glGenProgramPipelines(java.nio.IntBuffer arg0) {
		WRAPPER.glGenProgramPipelines(arg0);
	}


	/** GL46, GLES32 */
	public static void glGenProgramPipelines(int[] arg0) {
		WRAPPER.glGenProgramPipelines(arg0);
	}


	/** GL46 */
	public static void glProgramUniform2dv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glProgramUniform2dv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniform2dv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glProgramUniform2dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexImage(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glTexCoord1sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1sv(short[] arg0) {
		WRAPPER.glTexCoord1sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetPolygonStipple(long arg0) {
		WRAPPER.nglGetPolygonStipple(arg0);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,int[] arg3) {
		WRAPPER.glVertexAttribP1uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glVertexAttribP1uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetClipPlane(int arg0,long arg1) {
		WRAPPER.nglGetClipPlane(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord3dv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4s(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glRasterPos4s(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static boolean glIsSampler(int arg0) {
		return WRAPPER.glIsSampler(arg0);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2) {
		WRAPPER.glGetQueryObjecti64v(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjecti64v(int arg0,int arg1,long arg2) {
		WRAPPER.glGetQueryObjecti64v(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetQueryObjecti64v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4usv(java.nio.ShortBuffer arg0) {
		WRAPPER.glColor4usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4usv(short[] arg0) {
		WRAPPER.glColor4usv(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static float glGetMapf(int arg0,int arg1) {
		return WRAPPER.glGetMapf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glRasterPos4i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4f(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glRasterPos4f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGenVertexArrays(int arg0,long arg1) {
		WRAPPER.nglGenVertexArrays(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static double glGetMapd(int arg0,int arg1) {
		return WRAPPER.glGetMapd(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetMapi(int arg0,int arg1) {
		return WRAPPER.glGetMapi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4d(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glRasterPos4d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDrawPixels(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3d(double arg0,double arg1,double arg2) {
		WRAPPER.glSecondaryColor3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3f(float arg0,float arg1,float arg2) {
		WRAPPER.glSecondaryColor3f(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform1iv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform1iv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3b(byte arg0,byte arg1,byte arg2) {
		WRAPPER.glSecondaryColor3b(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3s(short arg0,short arg1,short arg2) {
		WRAPPER.glRasterPos3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetAttachedShaders(int arg0,int[] arg1,int[] arg2) {
		WRAPPER.glGetAttachedShaders(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetAttachedShaders(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetAttachedShaders(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3i(int arg0,int arg1,int arg2) {
		WRAPPER.glSecondaryColor3i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3s(short arg0,short arg1,short arg2) {
		WRAPPER.glSecondaryColor3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glClearStencil(int arg0) {
		WRAPPER.glClearStencil(arg0);
	}


	/** GL46 */
	public static void nglGetNamedFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetNamedFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglGetnHistogram(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL40, GL46 */
	public static void nglBindFragDataLocationIndexed(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglClearBufferData(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglClearBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3i(int arg0,int arg1,int arg2) {
		WRAPPER.glRasterPos3i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformsiv(int arg0,int[] arg1,int arg2,int[] arg3) {
		WRAPPER.glGetActiveUniformsiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetActiveUniformsiv(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetActiveUniformsiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glNamedFramebufferTexture(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glNamedFramebufferTexture(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,short[] arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,int[] arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,long[] arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,float[] arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,double[] arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferSubData(int arg0,long arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3f(float arg0,float arg1,float arg2) {
		WRAPPER.glRasterPos3f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTexParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTexParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3d(double arg0,double arg1,double arg2) {
		WRAPPER.glRasterPos3d(arg0,arg1,arg2);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glShaderBinary(int[] arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glShaderBinary(arg0,arg1,arg2);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glShaderBinary(java.nio.IntBuffer arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glShaderBinary(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,double[] arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,float[] arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.DoubleBuffer arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int[] arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,short[] arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ByteBuffer arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ShortBuffer arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.IntBuffer arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.FloatBuffer arg8) {
		WRAPPER.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform1fv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform1fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetActiveUniformBlockName(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.nglGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glMultiTexCoord3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3dv(int arg0,double[] arg1) {
		WRAPPER.glMultiTexCoord3dv(arg0,arg1);
	}


	/** GL46 */
	public static void glBindSamplers(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glBindSamplers(arg0,arg1);
	}


	/** GL46 */
	public static void glBindSamplers(int arg0,int[] arg1) {
		WRAPPER.glBindSamplers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2s(short arg0,short arg1) {
		WRAPPER.glRasterPos2s(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glTexStorage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6) {
		WRAPPER.glTexStorage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord3fv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglGetProgramPipelineInfoLog(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglDeleteTextures(int arg0,long arg1) {
		WRAPPER.nglDeleteTextures(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static int glGetInternalformati(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetInternalformati(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexubv(long arg0) {
		WRAPPER.nglIndexubv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2i(int arg0,int arg1) {
		WRAPPER.glRasterPos2i(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2f(float arg0,float arg1) {
		WRAPPER.glRasterPos2f(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2d(double arg0,double arg1) {
		WRAPPER.glRasterPos2d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawElements(int arg0,int[] arg1,int arg2,org.lwjgl.PointerBuffer arg3) {
		WRAPPER.glMultiDrawElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawElements(int arg0,java.nio.IntBuffer arg1,int arg2,org.lwjgl.PointerBuffer arg3) {
		WRAPPER.glMultiDrawElements(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.nglTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,short[] arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int[] arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.DoubleBuffer arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,double[] arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,float[] arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.ShortBuffer arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.ByteBuffer arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.IntBuffer arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.FloatBuffer arg9) {
		WRAPPER.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glEnablei(int arg0,int arg1) {
		WRAPPER.glEnablei(arg0,arg1);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCallLists(java.nio.IntBuffer arg0) {
		WRAPPER.glCallLists(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCallLists(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glCallLists(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCallLists(java.nio.ByteBuffer arg0) {
		WRAPPER.glCallLists(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCallLists(java.nio.ShortBuffer arg0) {
		WRAPPER.glCallLists(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex3sv(long arg0) {
		WRAPPER.nglVertex3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3bv(long arg0) {
		WRAPPER.nglColor3bv(arg0);
	}


	/** GL46 */
	public static void nglCreateSamplers(int arg0,long arg1) {
		WRAPPER.nglCreateSamplers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4) {
		WRAPPER.glColorMaski(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,double[] arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,float[] arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,int[] arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,short[] arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,java.nio.FloatBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,java.nio.DoubleBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,long arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glNamedBufferStorage(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glNamedBufferStorage(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glMultiTexCoord3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3fv(int arg0,float[] arg1) {
		WRAPPER.glMultiTexCoord3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glEvalCoord1dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1dv(double[] arg0) {
		WRAPPER.glEvalCoord1dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Nuiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Nuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,float[] arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferData(int arg0,double[] arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,long arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferData(int arg0,long[] arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,int[] arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,short[] arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferData(int arg0,java.nio.LongBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,java.nio.FloatBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferData(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferData(int arg0,java.nio.DoubleBuffer arg1,int arg2) {
		WRAPPER.glBufferData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexBuffer(int arg0,int arg1,int arg2) {
		WRAPPER.glTexBuffer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDetachShader(int arg0,int arg1) {
		WRAPPER.glDetachShader(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetIntegeri_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetIntegeri_v(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetIntegeri_v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform2iv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2iv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform2iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.ByteBuffer arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.ShortBuffer arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.IntBuffer arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.FloatBuffer arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int[] arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,short[] arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,double[] arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,float[] arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.DoubleBuffer arg7) {
		WRAPPER.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetBufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawBuffers(int[] arg0) {
		WRAPPER.glDrawBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawBuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glDrawBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawBuffers(int arg0) {
		WRAPPER.glDrawBuffers(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalPoint2(int arg0,int arg1) {
		WRAPPER.glEvalPoint2(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalPoint1(int arg0) {
		WRAPPER.glEvalPoint1(arg0);
	}


	/** GL46 */
	public static void glInvalidateBufferSubData(int arg0,long arg1,long arg2) {
		WRAPPER.glInvalidateBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetProgramInfoLog_String(int arg0) {
		return WRAPPER.glGetProgramInfoLog_String(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetProgramInfoLog_String(int arg0,int arg1) {
		return WRAPPER.glGetProgramInfoLog_String(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetProgramInfoLog(int arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetProgramInfoLog(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetProgramInfoLog(int arg0,int[] arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetProgramInfoLog(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static boolean nglIsSync(long arg0) {
		return WRAPPER.nglIsSync(arg0);
	}


	/** GL46 */
	public static void nglProgramUniform1dv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform1dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3dv(long arg0) {
		WRAPPER.nglColor3dv(arg0);
	}


	/** GL46 */
	public static void nglGetNamedBufferSubData(int arg0,long arg1,long arg2,long arg3) {
		WRAPPER.nglGetNamedBufferSubData(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetVertexArrayIndexed64iv(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3) {
		WRAPPER.glGetVertexArrayIndexed64iv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetVertexArrayIndexed64iv(int arg0,int arg1,int arg2,long[] arg3) {
		WRAPPER.glGetVertexArrayIndexed64iv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilMaskSeparate(int arg0,int arg1) {
		WRAPPER.glStencilMaskSeparate(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2fv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glProgramUniform2fv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glProgramUniform2fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1fv(float[] arg0) {
		WRAPPER.glEvalCoord1fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glEvalCoord1fv(arg0);
	}


	/** GL46 */
	public static void glGetDoublei_v(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetDoublei_v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetDoublei_v(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetDoublei_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glMultiTexCoord3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3iv(int arg0,int[] arg1) {
		WRAPPER.glMultiTexCoord3iv(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glGetBoolean(int arg0) {
		return WRAPPER.glGetBoolean(arg0);
	}


	/** GL40, GL46 */
	public static void glDrawTransformFeedback(int arg0,int arg1) {
		WRAPPER.glDrawTransformFeedback(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static double glGetDouble(int arg0) {
		return WRAPPER.glGetDouble(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexPointer(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexPointer(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexPointer(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexPointer(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord3iv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3fv(long arg0) {
		WRAPPER.nglColor3fv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetVertexAttribiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGendv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glTexGendv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGendv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glTexGendv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameteriv(int arg0,int[] arg1) {
		WRAPPER.glPointParameteriv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameteriv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glPointParameteriv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord3fv(long arg0) {
		WRAPPER.nglTexCoord3fv(arg0);
	}


	/** GL46 */
	public static void nglGetTextureLevelParameterfv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTextureLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4usv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4dv(double[] arg0) {
		WRAPPER.glRasterPos4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glRasterPos4dv(arg0);
	}


	/** GL46, GLES32 */
	public static void glPushDebugGroup(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glPushDebugGroup(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glPushDebugGroup(int arg0,int arg1,java.lang.CharSequence arg2) {
		WRAPPER.glPushDebugGroup(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glLineWidth(float arg0) {
		WRAPPER.glLineWidth(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetShaderSource(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetShaderSource(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform3uiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform3uiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferData(int arg0,int[] arg1) {
		WRAPPER.glInvalidateNamedFramebufferData(arg0,arg1);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferData(int arg0,int arg1) {
		WRAPPER.glInvalidateNamedFramebufferData(arg0,arg1);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferData(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glInvalidateNamedFramebufferData(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib3sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3sv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib3sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultMatrixd(long arg0) {
		WRAPPER.nglMultMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultMatrixf(long arg0) {
		WRAPPER.nglMultMatrixf(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform4fv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform4fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.FloatBuffer arg5) {
		WRAPPER.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5) {
		WRAPPER.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.IntBuffer arg5) {
		WRAPPER.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.ShortBuffer arg5) {
		WRAPPER.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL40, GL46 */
	public static void nglTexCoordP3uiv(int arg0,long arg1) {
		WRAPPER.nglTexCoordP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGenfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClampColor(int arg0,int arg1) {
		WRAPPER.glClampColor(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.nglCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetShaderi(int arg0,int arg1) {
		return WRAPPER.glGetShaderi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord3iv(long arg0) {
		WRAPPER.nglTexCoord3iv(arg0);
	}


	/** GL46 */
	public static void nglGetnPixelMapuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetnPixelMapuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetIntegeri_v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetIntegeri_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform4uiv(int arg0,int[] arg1) {
		WRAPPER.glUniform4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform4uiv(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static float glGetSamplerParameterf(int arg0,int arg1) {
		return WRAPPER.glGetSamplerParameterf(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static int glGetSamplerParameteri(int arg0,int arg1) {
		return WRAPPER.glGetSamplerParameteri(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glNormalP3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glNormalP3uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glNormalP3uiv(int arg0,int[] arg1) {
		WRAPPER.glNormalP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMaterialiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMaterialiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1iv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform1iv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform1iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawElements(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glDrawElements(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawElements(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glDrawElements(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawElements(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glDrawElements(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawElements(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glDrawElements(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDrawElements(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glDrawElements(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEnd() {
		WRAPPER.glEnd();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glPointParameterfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameterfv(int arg0,float[] arg1) {
		WRAPPER.glPointParameterfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord1iv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord1iv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static long glGetQueryObjecti64(int arg0,int arg1) {
		return WRAPPER.glGetQueryObjecti64(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniform4dv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform4dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glBindImageTextures(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glBindImageTextures(arg0,arg1);
	}


	/** GL46 */
	public static void glBindImageTextures(int arg0,int[] arg1) {
		WRAPPER.glBindImageTextures(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogiv(int arg0,int[] arg1) {
		WRAPPER.glFogiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glFogiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBlendFunc(int arg0,int arg1) {
		WRAPPER.glBlendFunc(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRecti(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glRecti(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3ubv(java.nio.ByteBuffer arg0) {
		WRAPPER.glColor3ubv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4s(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glTexCoord4s(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static int glCreateFramebuffers() {
		return WRAPPER.glCreateFramebuffers();
	}


	/** GL46 */
	public static void glCreateFramebuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateFramebuffers(arg0);
	}


	/** GL46 */
	public static void glCreateFramebuffers(int[] arg0) {
		WRAPPER.glCreateFramebuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3iv(int arg0,int[] arg1) {
		WRAPPER.glUniform3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetTexParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRects(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glRects(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglBindAttribLocation(int arg0,int arg1,long arg2) {
		WRAPPER.nglBindAttribLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3bv(long arg0) {
		WRAPPER.nglSecondaryColor3bv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4f(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glTexCoord4f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4d(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glTexCoord4d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static int glGetSamplerParameterIi(int arg0,int arg1) {
		return WRAPPER.glGetSamplerParameterIi(arg0,arg1);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glTexGeniv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGeniv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glTexGeniv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectfv(java.nio.FloatBuffer arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glRectfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectfv(float[] arg0,float[] arg1) {
		WRAPPER.glRectfv(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glBindSampler(int arg0,int arg1) {
		WRAPPER.glBindSampler(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetVertexAttribdv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glTexCoord4i(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.DoubleBuffer arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ByteBuffer arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.FloatBuffer arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.IntBuffer arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.ShortBuffer arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,float[] arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int[] arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,short[] arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,double[] arg8) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9) {
		WRAPPER.glGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glProvokingVertex(int arg0) {
		WRAPPER.glProvokingVertex(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteProgram(int arg0) {
		WRAPPER.glDeleteProgram(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glMaterialfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMaterialfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glMaterialfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetNamedBufferPointerv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetNamedBufferPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglColorP4uiv(int arg0,long arg1) {
		WRAPPER.nglColorP4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4iv(java.nio.IntBuffer arg0) {
		WRAPPER.glRasterPos4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4iv(int[] arg0) {
		WRAPPER.glRasterPos4iv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetIntegerv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glGetIntegerv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetIntegerv(int arg0,int[] arg1) {
		WRAPPER.glGetIntegerv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5) {
		WRAPPER.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapuiv(int arg0,int[] arg1) {
		WRAPPER.glPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapuiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapuiv(int arg0,int arg1,long arg2) {
		WRAPPER.glPixelMapuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectd(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glRectd(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetTextureParameterIuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectf(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glRectf(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,int[] arg3) {
		WRAPPER.glVertexAttribP3uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glVertexAttribP3uiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTextureParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTextureParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTextureParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEnableClientState(int arg0) {
		WRAPPER.glEnableClientState(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4sv(short[] arg0) {
		WRAPPER.glTexCoord4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glTexCoord4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3dv(long arg0) {
		WRAPPER.nglSecondaryColor3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMaterialfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMaterialfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetFragDataLocation(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glGetFragDataLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetFragDataLocation(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetFragDataLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord3dv(long arg0) {
		WRAPPER.nglTexCoord3dv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglGetFramebufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static boolean glAreTexturesResident_boolean(int[] arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glAreTexturesResident_boolean(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static boolean glAreTexturesResident_boolean(java.nio.IntBuffer arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glAreTexturesResident_boolean(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static boolean glAreTexturesResident_boolean(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glAreTexturesResident_boolean(arg0,arg1);
	}


	/** GL46 */
	public static void nglClearNamedBufferData(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglClearNamedBufferData(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetInteger64i_v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetInteger64i_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glRasterPos4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos4fv(float[] arg0) {
		WRAPPER.glRasterPos4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glFogfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogfv(int arg0,float[] arg1) {
		WRAPPER.glFogfv(arg0,arg1);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glReleaseShaderCompiler() {
		WRAPPER.glReleaseShaderCompiler();
	}


	/** GL46 */
	public static void glDrawTransformFeedbackInstanced(int arg0,int arg1,int arg2) {
		WRAPPER.glDrawTransformFeedbackInstanced(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPushName(int arg0) {
		WRAPPER.glPushName(arg0);
	}


	/** GL46 */
	public static void glGetTextureLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3) {
		WRAPPER.glGetTextureLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTextureLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glGetTextureLevelParameterfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLoadMatrixf(long arg0) {
		WRAPPER.nglLoadMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetIntegeri(int arg0,int arg1) {
		return WRAPPER.glGetIntegeri(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLoadMatrixd(long arg0) {
		WRAPPER.nglLoadMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectdv(java.nio.DoubleBuffer arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glRectdv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectdv(double[] arg0,double[] arg1) {
		WRAPPER.glRectdv(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetCompressedTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9) {
		WRAPPER.nglGetCompressedTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetTexParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetVertexAttribfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glTexParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glTexParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glTexParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformBlockBinding(int arg0,int arg1,int arg2) {
		WRAPPER.glUniformBlockBinding(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglGetSamplerParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexAttribP2uiv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglVertexAttribP2uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glCheckFramebufferStatus(int arg0) {
		return WRAPPER.glCheckFramebufferStatus(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetLightiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetLightiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLoadIdentity() {
		WRAPPER.glLoadIdentity();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetActiveUniformName(int arg0,int arg1,int[] arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetActiveUniformName(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetActiveUniformName(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetActiveUniformName(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static java.lang.String glGetActiveUniformName_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveUniformName_String(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static java.lang.String glGetActiveUniformName_String(int arg0,int arg1) {
		return WRAPPER.glGetActiveUniformName_String(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetTextureLevelParameteriv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTextureLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawElementsInstanced(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsInstanced(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawElementsInstanced(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsInstanced(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawElementsInstanced(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsInstanced(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawElementsInstanced(int arg0,int arg1,int arg2,long arg3,int arg4) {
		WRAPPER.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDrawElementsInstanced(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3) {
		WRAPPER.glDrawElementsInstanced(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetTransformFeedbacki_v(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetTransformFeedbacki_v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static long glGetVertexArrayIndexed64i(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetVertexArrayIndexed64i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2f(int arg0,float arg1,float arg2) {
		WRAPPER.glMultiTexCoord2f(arg0,arg1,arg2);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glResumeTransformFeedback() {
		WRAPPER.glResumeTransformFeedback();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2d(int arg0,double arg1,double arg2) {
		WRAPPER.glMultiTexCoord2d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEdgeFlagv(java.nio.ByteBuffer arg0) {
		WRAPPER.glEdgeFlagv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2i(int arg0,int arg1,int arg2) {
		WRAPPER.glMultiTexCoord2i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3ubv(long arg0) {
		WRAPPER.nglColor3ubv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMaterialiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glMaterialiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMaterialiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMaterialiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4iv(int[] arg0) {
		WRAPPER.glTexCoord4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4iv(java.nio.IntBuffer arg0) {
		WRAPPER.glTexCoord4iv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP3ui(int arg0,int arg1,boolean arg2,int arg3) {
		WRAPPER.glVertexAttribP3ui(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI2iv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3iv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glColor4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4fv(float[] arg0) {
		WRAPPER.glColor4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMapGrid2d(int arg0,double arg1,double arg2,int arg3,double arg4,double arg5) {
		WRAPPER.glMapGrid2d(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static long glGetTransformFeedbacki64(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTransformFeedbacki64(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMapGrid2f(int arg0,float arg1,float arg2,int arg3,float arg4,float arg5) {
		WRAPPER.glMapGrid2f(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4x3dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix4x3dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4x3dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix4x3dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBindFramebuffer(int arg0,int arg1) {
		WRAPPER.glBindFramebuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1s(int arg0,short arg1) {
		WRAPPER.glMultiTexCoord1s(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteQueries(int arg0) {
		WRAPPER.glDeleteQueries(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteQueries(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteQueries(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteQueries(int[] arg0) {
		WRAPPER.glDeleteQueries(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib3dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetQueryiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetQueryiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetUniformiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetUniformiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetUniformiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGenfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetTexGenfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1s(short arg0) {
		WRAPPER.glTexCoord1s(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsShader(int arg0) {
		return WRAPPER.glIsShader(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBitmap(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5,long arg6) {
		WRAPPER.glBitmap(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1f(int arg0,float arg1) {
		WRAPPER.glMultiTexCoord1f(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glBlendFunci(int arg0,int arg1,int arg2) {
		WRAPPER.glBlendFunci(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1d(int arg0,double arg1) {
		WRAPPER.glMultiTexCoord1d(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexP2uiv(int arg0,long arg1) {
		WRAPPER.nglVertexP2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1i(int arg0,int arg1) {
		WRAPPER.glMultiTexCoord1i(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetTexParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexParameteriv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniform3dv(int arg0,double[] arg1) {
		WRAPPER.glUniform3dv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniform3dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glUniform3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetShaderInfoLog_String(int arg0) {
		return WRAPPER.glGetShaderInfoLog_String(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderInfoLog(int arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetShaderInfoLog(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderInfoLog(int arg0,int[] arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetShaderInfoLog(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetShaderInfoLog_String(int arg0,int arg1) {
		return WRAPPER.glGetShaderInfoLog_String(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1d(double arg0) {
		WRAPPER.glTexCoord1d(arg0);
	}


	/** GL46 */
	public static void nglClearTexImage(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglClearTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4usv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttribI4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4usv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttribI4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectiv(java.nio.IntBuffer arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glRectiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRectiv(int[] arg0,int[] arg1) {
		WRAPPER.glRectiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRectsv(long arg0,long arg1) {
		WRAPPER.nglRectsv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClearAccum(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glClearAccum(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1i(int arg0) {
		WRAPPER.glTexCoord1i(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord1f(float arg0) {
		WRAPPER.glTexCoord1f(arg0);
	}


	/** GL46 */
	public static void glGetNamedBufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetNamedBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetNamedBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetInternalformati64v(int arg0,int arg1,int arg2,long[] arg3) {
		WRAPPER.glGetInternalformati64v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetInternalformati64v(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3) {
		WRAPPER.glGetInternalformati64v(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4dv(double[] arg0) {
		WRAPPER.glColor4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glColor4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglVertexPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glFramebufferTexture(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2s(short arg0,short arg1) {
		WRAPPER.glTexCoord2s(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglGetSamplerParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3uiv(int[] arg0) {
		WRAPPER.glSecondaryColor3uiv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3uiv(java.nio.IntBuffer arg0) {
		WRAPPER.glSecondaryColor3uiv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDepthFunc(int arg0) {
		WRAPPER.glDepthFunc(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetLightfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetLightfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetLightfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexiv(java.nio.IntBuffer arg0) {
		WRAPPER.glIndexiv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexiv(int[] arg0) {
		WRAPPER.glIndexiv(arg0);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.ByteBuffer arg9) {
		WRAPPER.glCompressedTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.glCompressedTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4x3fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix4x3fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4x3fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix4x3fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTexGeniv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGeniv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTexGeniv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglVertexArrayVertexBuffers(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5) {
		WRAPPER.nglVertexArrayVertexBuffers(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2f(float arg0,float arg1) {
		WRAPPER.glTexCoord2f(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetUniformIndices(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetUniformIndices(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2d(double arg0,double arg1) {
		WRAPPER.glTexCoord2d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord2i(int arg0,int arg1) {
		WRAPPER.glTexCoord2i(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4uiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4uiv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glVertexBindingDivisor(int arg0,int arg1) {
		WRAPPER.glVertexBindingDivisor(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexArrayAttribFormat(int arg0,int arg1,int arg2,int arg3,boolean arg4,int arg5) {
		WRAPPER.glVertexArrayAttribFormat(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3s(short arg0,short arg1,short arg2) {
		WRAPPER.glTexCoord3s(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glVertexArrayAttribIFormat(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glVertexArrayAttribIFormat(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glUniform3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3fv(int arg0,float[] arg1) {
		WRAPPER.glUniform3fv(arg0,arg1);
	}


	/** GL46 */
	public static long nglMapNamedBuffer(int arg0,int arg1) {
		return WRAPPER.nglMapNamedBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetBufferSubData(int arg0,long arg1,long arg2,long arg3) {
		WRAPPER.nglGetBufferSubData(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMapGrid1d(int arg0,double arg1,double arg2) {
		WRAPPER.glMapGrid1d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3f(float arg0,float arg1,float arg2) {
		WRAPPER.glTexCoord3f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMapGrid1f(int arg0,float arg1,float arg2) {
		WRAPPER.glMapGrid1f(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glVertexArrayVertexBuffers(int arg0,int arg1,java.nio.IntBuffer arg2,org.lwjgl.PointerBuffer arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glVertexArrayVertexBuffers(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glVertexArrayVertexBuffers(int arg0,int arg1,int[] arg2,org.lwjgl.PointerBuffer arg3,int[] arg4) {
		WRAPPER.glVertexArrayVertexBuffers(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3d(double arg0,double arg1,double arg2) {
		WRAPPER.glTexCoord3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glTexCoord4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4fv(float[] arg0) {
		WRAPPER.glTexCoord4fv(arg0);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glGenTransformFeedbacks(java.nio.IntBuffer arg0) {
		WRAPPER.glGenTransformFeedbacks(arg0);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glGenTransformFeedbacks(int[] arg0) {
		WRAPPER.glGenTransformFeedbacks(arg0);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static int glGenTransformFeedbacks() {
		return WRAPPER.glGenTransformFeedbacks();
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP1uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glMultiTexCoordP1uiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP1uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMultiTexCoordP1uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos2sv(long arg0) {
		WRAPPER.nglWindowPos2sv(arg0);
	}


	/** GL46 */
	public static void nglGetnPolygonStipple(int arg0,long arg1) {
		WRAPPER.nglGetnPolygonStipple(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3i(int arg0,int arg1,int arg2) {
		WRAPPER.glTexCoord3i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib3fv(int arg0,float[] arg1) {
		WRAPPER.glVertexAttrib3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glVertexAttrib3fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilMask(int arg0) {
		WRAPPER.glStencilMask(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCopyTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6) {
		WRAPPER.glCopyTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniform3uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform3uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4bv(java.nio.ByteBuffer arg0) {
		WRAPPER.glColor4bv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetInteger(int arg0) {
		return WRAPPER.glGetInteger(arg0);
	}


	/** GL40, GL46 */
	public static void glGetUniformdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetUniformdv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glGetUniformdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetUniformdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribPointerv(int arg0,int arg1,org.lwjgl.PointerBuffer arg2) {
		WRAPPER.glGetVertexAttribPointerv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBlendEquationSeparate(int arg0,int arg1) {
		WRAPPER.glBlendEquationSeparate(arg0,arg1);
	}


	/** GL46 */
	public static void glTransformFeedbackBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.glTransformFeedbackBufferRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glViewportIndexedf(int arg0,float arg1,float arg2,float arg3,float arg4) {
		WRAPPER.glViewportIndexedf(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glCompressedTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glCompressedTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glPauseTransformFeedback() {
		WRAPPER.glPauseTransformFeedback();
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetUniformuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetUniformuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetUniformuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1sv(int arg0,short[] arg1) {
		WRAPPER.glMultiTexCoord1sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glMultiTexCoord1sv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP1ui(int arg0,int arg1,int arg2) {
		WRAPPER.glMultiTexCoordP1ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3ubv(java.nio.ByteBuffer arg0) {
		WRAPPER.glSecondaryColor3ubv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7) {
		WRAPPER.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46 */
	public static void nglGetnPixelMapusv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetnPixelMapusv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glCreateVertexArrays(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateVertexArrays(arg0);
	}


	/** GL46 */
	public static int glCreateVertexArrays() {
		return WRAPPER.glCreateVertexArrays();
	}


	/** GL46 */
	public static void glCreateVertexArrays(int[] arg0) {
		WRAPPER.glCreateVertexArrays(arg0);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,float[] arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,int[] arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,double[] arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,long[] arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,short[] arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetBufferSubData(int arg0,long arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexdv(double[] arg0) {
		WRAPPER.glIndexdv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexdv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glIndexdv(arg0);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glCompressedTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void glCompressedTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.ByteBuffer arg7) {
		WRAPPER.glCompressedTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClearDepth(double arg0) {
		WRAPPER.glClearDepth(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteTextures(int[] arg0) {
		WRAPPER.glDeleteTextures(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteTextures(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteTextures(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteTextures(int arg0) {
		WRAPPER.glDeleteTextures(arg0);
	}


	/** GL46 */
	public static int glGetNamedBufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetNamedBufferParameteri(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4s(int arg0,short arg1,short arg2,short arg3,short arg4) {
		WRAPPER.glMultiTexCoord4s(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3uiv(java.nio.IntBuffer arg0) {
		WRAPPER.glColor3uiv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3uiv(int[] arg0) {
		WRAPPER.glColor3uiv(arg0);
	}


	/** GL46 */
	public static void glNamedFramebufferDrawBuffers(int arg0,int arg1) {
		WRAPPER.glNamedFramebufferDrawBuffers(arg0,arg1);
	}


	/** GL46 */
	public static void glNamedFramebufferDrawBuffers(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glNamedFramebufferDrawBuffers(arg0,arg1);
	}


	/** GL46 */
	public static void glNamedFramebufferDrawBuffers(int arg0,int[] arg1) {
		WRAPPER.glNamedFramebufferDrawBuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long glGetBufferParameteri64(int arg0,int arg1) {
		return WRAPPER.glGetBufferParameteri64(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglBindFragDataLocation(int arg0,int arg1,long arg2) {
		WRAPPER.nglBindFragDataLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord1sv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord1sv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniform4dv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform4dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4d(int arg0,double arg1,double arg2,double arg3,double arg4) {
		WRAPPER.glMultiTexCoord4d(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnPixelMapusv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glGetnPixelMapusv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnPixelMapusv(int arg0,short[] arg1) {
		WRAPPER.glGetnPixelMapusv(arg0,arg1);
	}


	/** GL46 */
	public static void nglVertexAttribL3dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribL3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetUniformfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetUniformfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetUniformfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttrib3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttrib3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4i(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glMultiTexCoord4i(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsBaseVertex(int arg0,java.nio.IntBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsBaseVertex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsBaseVertex(int arg0,java.nio.ShortBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsBaseVertex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4) {
		WRAPPER.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsBaseVertex(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3) {
		WRAPPER.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawElementsBaseVertex(int arg0,java.nio.ByteBuffer arg1,int arg2) {
		WRAPPER.glDrawElementsBaseVertex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4) {
		WRAPPER.glMultiTexCoord4f(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glVertexAttribL4dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttribL4dv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexAttribL4dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttribL4dv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static int glGetSubroutineIndex(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glGetSubroutineIndex(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static int glGetSubroutineIndex(int arg0,int arg1,java.lang.CharSequence arg2) {
		return WRAPPER.glGetSubroutineIndex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3s(int arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glMultiTexCoord3s(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnPixelMapfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glGetnPixelMapfv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnPixelMapfv(int arg0,float[] arg1) {
		WRAPPER.glGetnPixelMapfv(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetnSeparableFilter(int arg0,int arg1,int arg2,int arg3,long arg4,int arg5,long arg6,long arg7) {
		WRAPPER.nglGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetPixelMapusv(int arg0,long arg1) {
		WRAPPER.nglGetPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetTransformFeedbackVarying(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5,long arg6) {
		WRAPPER.nglGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglVertexAttrib3fv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib3fv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1ui(int arg0,int arg1,int arg2) {
		WRAPPER.glProgramUniform1ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3d(int arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glMultiTexCoord3d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGendv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetTexGendv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetTexGendv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetTexGendv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPopName() {
		WRAPPER.glPopName();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3f(int arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glMultiTexCoord3f(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexfv(float[] arg0) {
		WRAPPER.glIndexfv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexfv(java.nio.FloatBuffer arg0) {
		WRAPPER.glIndexfv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static boolean glIsList(int arg0) {
		return WRAPPER.glIsList(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord3i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glMultiTexCoord3i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetFloatv(int arg0,long arg1) {
		WRAPPER.nglGetFloatv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2s(int arg0,short arg1,short arg2) {
		WRAPPER.glMultiTexCoord2s(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform2uiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform2uiv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglGetProgramResourceiv(int arg0,int arg1,int arg2,int arg3,long arg4,int arg5,long arg6,long arg7) {
		WRAPPER.nglGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46 */
	public static void glGetQueryBufferObjectui64v(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetQueryBufferObjectui64v(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetString(int arg0) {
		return WRAPPER.glGetString(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglDeleteSamplers(int arg0,long arg1) {
		WRAPPER.nglDeleteSamplers(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniform3dv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform3dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttrib4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttrib4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetActiveUniformBlockiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glRenderbufferStorage(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRectiv(long arg0,long arg1) {
		WRAPPER.nglRectiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelZoom(float arg0,float arg1) {
		WRAPPER.glPixelZoom(arg0,arg1);
	}


	/** GL40, GL46 */
	public static int glGetSubroutineUniformLocation(int arg0,int arg1,java.lang.CharSequence arg2) {
		return WRAPPER.glGetSubroutineUniformLocation(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static int glGetSubroutineUniformLocation(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glGetSubroutineUniformLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGenf(int arg0,int arg1,float arg2) {
		WRAPPER.glTexGenf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGeni(int arg0,int arg1,int arg2) {
		WRAPPER.glTexGeni(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2iv(int arg0,int[] arg1) {
		WRAPPER.glMultiTexCoord2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glMultiTexCoord2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglCallLists(int arg0,int arg1,long arg2) {
		WRAPPER.nglCallLists(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static float glGetFloat(int arg0) {
		return WRAPPER.glGetFloat(arg0);
	}


	/** GL46 */
	public static void glBlitNamedFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,int arg11) {
		WRAPPER.glBlitNamedFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glNormal3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3fv(float[] arg0) {
		WRAPPER.glNormal3fv(arg0);
	}


	/** GL40, GL46 */
	public static int nglGetSubroutineUniformLocation(int arg0,int arg1,long arg2) {
		return WRAPPER.nglGetSubroutineUniformLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static int glGetTexParameterIui(int arg0,int arg1) {
		return WRAPPER.glGetTexParameterIui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexGend(int arg0,int arg1,double arg2) {
		WRAPPER.glTexGend(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetBooleani_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetQueryiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetQueryiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetQueryiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4ubv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4ubv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glRasterPos3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3sv(short[] arg0) {
		WRAPPER.glRasterPos3sv(arg0);
	}


	/** GL46 */
	public static void nglDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5,int arg6) {
		WRAPPER.nglDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void nglGetnConvolutionFilter(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetnConvolutionFilter(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetInteger64v(int arg0,long[] arg1) {
		WRAPPER.glGetInteger64v(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetInteger64v(int arg0,java.nio.LongBuffer arg1) {
		WRAPPER.glGetInteger64v(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void nglInvalidateSubFramebuffer(int arg0,int arg1,long arg2,int arg3,int arg4,int arg5,int arg6) {
		WRAPPER.nglInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void nglClearNamedFramebufferfv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglClearNamedFramebufferfv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapuiv(int arg0,int[] arg1) {
		WRAPPER.glGetPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapuiv(int arg0,long arg1) {
		WRAPPER.glGetPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapuiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glGetPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2fv(float[] arg0) {
		WRAPPER.glWindowPos2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glWindowPos2fv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetSynciv(long arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetSynciv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetSynciv(long arg0,int arg1,int[] arg2,int[] arg3) {
		WRAPPER.glGetSynciv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.glGetnHistogram(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetnHistogram(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglGetProgramPipelineiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetProgramPipelineiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4bv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttrib4bv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform3fv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform3fv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglClearNamedFramebufferiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglClearNamedFramebufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenBuffers(int[] arg0) {
		WRAPPER.glGenBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGenBuffers() {
		return WRAPPER.glGenBuffers();
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenBuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glGenBuffers(arg0);
	}


	/** GL46 */
	public static void glNamedFramebufferDrawBuffer(int arg0,int arg1) {
		WRAPPER.glNamedFramebufferDrawBuffer(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int nglGetProgramResourceLocation(int arg0,int arg1,long arg2) {
		return WRAPPER.nglGetProgramResourceLocation(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglGetObjectPtrLabel(long arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetObjectPtrLabel(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglDeleteBuffers(int arg0,long arg1) {
		WRAPPER.nglDeleteBuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2dv(double[] arg0) {
		WRAPPER.glWindowPos2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glWindowPos2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalMesh1(int arg0,int arg1,int arg2) {
		WRAPPER.glEvalMesh1(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalMesh2(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glEvalMesh2(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glFramebufferParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glFramebufferParameteri(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glViewportArrayv(int arg0,float[] arg1) {
		WRAPPER.glViewportArrayv(arg0,arg1);
	}


	/** GL46 */
	public static void glViewportArrayv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glViewportArrayv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glNormal3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3iv(int[] arg0) {
		WRAPPER.glNormal3iv(arg0);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void nglGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,long arg4,long arg5) {
		WRAPPER.nglGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex4sv(long arg0) {
		WRAPPER.nglVertex4sv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP2ui(int arg0,int arg1) {
		WRAPPER.glTexCoordP2ui(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnPixelMapuiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glGetnPixelMapuiv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnPixelMapuiv(int arg0,int[] arg1) {
		WRAPPER.glGetnPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3bv(java.nio.ByteBuffer arg0) {
		WRAPPER.glNormal3bv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexPointer(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glIndexPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexPointer(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glIndexPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexPointer(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glIndexPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexPointer(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glIndexPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexPointer(int arg0,int arg1,long arg2) {
		WRAPPER.glIndexPointer(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglCompressedTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglCompressedTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static int glCreateShaderProgramv(int arg0,org.lwjgl.PointerBuffer arg1) {
		return WRAPPER.glCreateShaderProgramv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int glCreateShaderProgramv(int arg0,java.lang.CharSequence... arg1) {
		return WRAPPER.glCreateShaderProgramv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int glCreateShaderProgramv(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glCreateShaderProgramv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos4sv(long arg0) {
		WRAPPER.nglRasterPos4sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform3iv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform3iv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int[] arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,short[] arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.FloatBuffer arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ByteBuffer arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ShortBuffer arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.IntBuffer arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.DoubleBuffer arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,double[] arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,float[] arg10) {
		WRAPPER.glClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEndList() {
		WRAPPER.glEndList();
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetTransformFeedbackVarying(int arg0,int arg1,int[] arg2,int[] arg3,int[] arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.lang.String glGetTransformFeedbackVarying_String(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4) {
		return WRAPPER.glGetTransformFeedbackVarying_String(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetTransformFeedbackVarying(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.lang.String glGetTransformFeedbackVarying_String(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		return WRAPPER.glGetTransformFeedbackVarying_String(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3sv(long arg0) {
		WRAPPER.nglSecondaryColor3sv(arg0);
	}


	/** GL46 */
	public static void glGetVertexAttribLdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetVertexAttribLdv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetVertexAttribLdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetVertexAttribLdv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexP4uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP4uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexP4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGenRenderbuffers(int arg0,long arg1) {
		WRAPPER.nglGenRenderbuffers(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRectfv(long arg0,long arg1) {
		WRAPPER.nglRectfv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexAttribLFormat(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glVertexAttribLFormat(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorPointer(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorPointer(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorPointer(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorPointer(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexdv(long arg0) {
		WRAPPER.nglIndexdv(arg0);
	}


	/** GL46 */
	public static void nglCompressedTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglCompressedTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static long nglGetString(int arg0) {
		return WRAPPER.nglGetString(arg0);
	}


	/** GL46 */
	public static void glNamedFramebufferReadBuffer(int arg0,int arg1) {
		WRAPPER.glNamedFramebufferReadBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglInterleavedArrays(int arg0,int arg1,long arg2) {
		WRAPPER.nglInterleavedArrays(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glNormal3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glNormal3dv(double[] arg0) {
		WRAPPER.glNormal3dv(arg0);
	}


	/** GL46 */
	public static void nglCompressedTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.nglCompressedTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GLES32 */
	public static void glBlendBarrier() {
		WRAPPER.glBlendBarrier();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2iv(java.nio.IntBuffer arg0) {
		WRAPPER.glWindowPos2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2iv(int[] arg0) {
		WRAPPER.glWindowPos2iv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long glGetInteger64i(int arg0,int arg1) {
		return WRAPPER.glGetInteger64i(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexArrayAttribLFormat(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glVertexArrayAttribLFormat(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord2sv(long arg0) {
		WRAPPER.nglTexCoord2sv(arg0);
	}


	/** GL46 */
	public static void glPolygonOffsetClamp(float arg0,float arg1,float arg2) {
		WRAPPER.glPolygonOffsetClamp(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRectdv(long arg0,long arg1) {
		WRAPPER.nglRectdv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4iv(int[] arg0) {
		WRAPPER.glColor4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4iv(java.nio.IntBuffer arg0) {
		WRAPPER.glColor4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexfv(long arg0) {
		WRAPPER.nglIndexfv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5) {
		WRAPPER.nglVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos3iv(long arg0) {
		WRAPPER.nglWindowPos3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3ui(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glVertexAttribI3ui(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexArrayBindingDivisor(int arg0,int arg1,int arg2) {
		WRAPPER.glVertexArrayBindingDivisor(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEdgeFlagv(long arg0) {
		WRAPPER.nglEdgeFlagv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetError() {
		return WRAPPER.glGetError();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLoadTransposeMatrixd(long arg0) {
		WRAPPER.nglLoadTransposeMatrixd(arg0);
	}


	/** GL46, GLES32 */
	public static void nglDebugMessageInsert(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglDebugMessageInsert(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL40, GL46, GLES32 */
	public static void glPatchParameteri(int arg0,int arg1) {
		WRAPPER.glPatchParameteri(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglLoadTransposeMatrixf(long arg0) {
		WRAPPER.nglLoadTransposeMatrixf(arg0);
	}


	/** GL46, GLES32 */
	public static int glGetGraphicsResetStatus() {
		return WRAPPER.glGetGraphicsResetStatus();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos3dv(long arg0) {
		WRAPPER.nglWindowPos3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3fv(long arg0) {
		WRAPPER.nglSecondaryColor3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLogicOp(int arg0) {
		WRAPPER.glLogicOp(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform3ui(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glUniform3ui(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glCopyTextureSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8) {
		WRAPPER.glCopyTextureSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glScissor(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glScissor(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static long glGetQueryObjectui64(int arg0,int arg1) {
		return WRAPPER.glGetQueryObjectui64(arg0,arg1);
	}


	/** GL46 */
	public static boolean glUnmapNamedBuffer(int arg0) {
		return WRAPPER.glUnmapNamedBuffer(arg0);
	}


	/** GL46 */
	public static void glProgramUniform1d(int arg0,int arg1,double arg2) {
		WRAPPER.glProgramUniform1d(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1f(int arg0,int arg1,float arg2) {
		WRAPPER.glProgramUniform1f(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1i(int arg0,int arg1,int arg2) {
		WRAPPER.glProgramUniform1i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetBooleanv(int arg0,long arg1) {
		WRAPPER.nglGetBooleanv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,java.nio.DoubleBuffer arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glGetTextureImage(int arg0,int arg1,int arg2,int arg3,double[] arg4) {
		WRAPPER.glGetTextureImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4ui(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glColor4ui(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static long nglMapNamedBufferRange(int arg0,long arg1,long arg2,int arg3) {
		return WRAPPER.nglMapNamedBufferRange(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultTransposeMatrixd(long arg0) {
		WRAPPER.nglMultTransposeMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib3sv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib3sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3) {
		WRAPPER.glColor4ub(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glCopyTextureSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7) {
		WRAPPER.glCopyTextureSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultTransposeMatrixf(long arg0) {
		WRAPPER.nglMultTransposeMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexEnviv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glTexParameterIi(int arg0,int arg1,int arg2) {
		WRAPPER.glTexParameterIi(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos3fv(long arg0) {
		WRAPPER.nglWindowPos3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord2dv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord2dv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP3uiv(int arg0,int[] arg1) {
		WRAPPER.glColorP3uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glColorP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glClientWaitSync(long arg0,int arg1,long arg2) {
		return WRAPPER.glClientWaitSync(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColor3iv(long arg0) {
		WRAPPER.nglSecondaryColor3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4us(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glColor4us(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glViewportIndexedfv(int arg0,float[] arg1) {
		WRAPPER.glViewportIndexedfv(arg0,arg1);
	}


	/** GL46 */
	public static void glViewportIndexedfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glViewportIndexedfv(arg0,arg1);
	}


	/** GL40, GL46, GLES32 */
	public static void glBlendEquationSeparatei(int arg0,int arg1,int arg2) {
		WRAPPER.glBlendEquationSeparatei(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,long[] arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,double[] arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,float[] arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,short[] arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,int[] arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedBufferSubData(int arg0,long arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glGetNamedBufferSubData(arg0,arg1,arg2);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void nglShaderBinary(int arg0,long arg1,int arg2,long arg3,int arg4) {
		WRAPPER.nglShaderBinary(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPointParameterfv(int arg0,long arg1) {
		WRAPPER.nglPointParameterfv(arg0,arg1);
	}


	/** GL46 */
	public static void glCopyTextureSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glCopyTextureSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3usv(java.nio.ShortBuffer arg0) {
		WRAPPER.glColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3usv(short[] arg0) {
		WRAPPER.glColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapusv(int arg0,long arg1) {
		WRAPPER.glGetPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapusv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glGetPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapusv(int arg0,short[] arg1) {
		WRAPPER.glGetPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglSecondaryColorPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapusv(int arg0,short[] arg1) {
		WRAPPER.glPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapusv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glPixelMapusv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelMapusv(int arg0,int arg1,long arg2) {
		WRAPPER.glPixelMapusv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1fv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glProgramUniform1fv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glProgramUniform1fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexsv(short[] arg0) {
		WRAPPER.glIndexsv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexsv(java.nio.ShortBuffer arg0) {
		WRAPPER.glIndexsv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetUniformui(int arg0,int arg1) {
		return WRAPPER.glGetUniformui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglWaitSync(long arg0,int arg1,long arg2) {
		WRAPPER.nglWaitSync(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI2uiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glMultiTexCoord2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2dv(int arg0,double[] arg1) {
		WRAPPER.glMultiTexCoord2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib4Nsv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib4Nsv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glColor4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4sv(short[] arg0) {
		WRAPPER.glColor4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord2fv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap1d(int arg0,double arg1,double arg2,int arg3,int arg4,double[] arg5) {
		WRAPPER.glMap1d(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap1d(int arg0,double arg1,double arg2,int arg3,int arg4,java.nio.DoubleBuffer arg5) {
		WRAPPER.glMap1d(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap1f(int arg0,float arg1,float arg2,int arg3,int arg4,float[] arg5) {
		WRAPPER.glMap1f(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap1f(int arg0,float arg1,float arg2,int arg3,int arg4,java.nio.FloatBuffer arg5) {
		WRAPPER.glMap1f(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glAttachShader(int arg0,int arg1) {
		WRAPPER.glAttachShader(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetRenderbufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glPatchParameterfv(int arg0,float[] arg1) {
		WRAPPER.glPatchParameterfv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glPatchParameterfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glPatchParameterfv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glMemoryBarrierByRegion(int arg0) {
		WRAPPER.glMemoryBarrierByRegion(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glClearIndex(float arg0) {
		WRAPPER.glClearIndex(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexub(byte arg0) {
		WRAPPER.glIndexub(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEvalCoord1fv(long arg0) {
		WRAPPER.nglEvalCoord1fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap2d(int arg0,double arg1,double arg2,int arg3,int arg4,double arg5,double arg6,int arg7,int arg8,double[] arg9) {
		WRAPPER.glMap2d(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap2d(int arg0,double arg1,double arg2,int arg3,int arg4,double arg5,double arg6,int arg7,int arg8,java.nio.DoubleBuffer arg9) {
		WRAPPER.glMap2d(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP4ui(int arg0,int arg1) {
		WRAPPER.glVertexP4ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap2f(int arg0,float arg1,float arg2,int arg3,int arg4,float arg5,float arg6,int arg7,int arg8,java.nio.FloatBuffer arg9) {
		WRAPPER.glMap2f(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMap2f(int arg0,float arg1,float arg2,int arg3,int arg4,float arg5,float arg6,int arg7,int arg8,float[] arg9) {
		WRAPPER.glMap2f(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL46 */
	public static void nglGetVertexAttribLdv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexAttribLdv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static int glGetProgramResourceLocation(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glGetProgramResourceLocation(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static int glGetProgramResourceLocation(int arg0,int arg1,java.lang.CharSequence arg2) {
		return WRAPPER.glGetProgramResourceLocation(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glTexCoordPointer(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniform1dv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glProgramUniform1dv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniform1dv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glProgramUniform1dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2fv(int arg0,float[] arg1) {
		WRAPPER.glMultiTexCoord2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord2fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glMultiTexCoord2fv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glGetFramebufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glGetFramebufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPointParameteriv(int arg0,long arg1) {
		WRAPPER.nglPointParameteriv(arg0,arg1);
	}


	/** GL46 */
	public static void glSpecializeShader(int arg0,java.lang.CharSequence arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glSpecializeShader(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glSpecializeShader(int arg0,java.lang.CharSequence arg1,int[] arg2,int[] arg3) {
		WRAPPER.glSpecializeShader(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glSpecializeShader(int arg0,java.nio.ByteBuffer arg1,int[] arg2,int[] arg3) {
		WRAPPER.glSpecializeShader(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glSpecializeShader(int arg0,java.nio.ByteBuffer arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glSpecializeShader(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3,int arg4) {
		WRAPPER.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,int arg4) {
		WRAPPER.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5,int arg6) {
		WRAPPER.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4,int arg5) {
		WRAPPER.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3,int arg4) {
		WRAPPER.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetTexEnvfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTexEnvfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglClearBufferSubData(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglClearBufferSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform4iv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform4iv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBeginTransformFeedback(int arg0) {
		WRAPPER.glBeginTransformFeedback(arg0);
	}


	/** GL46, GLES32 */
	public static void glObjectPtrLabel(long arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glObjectPtrLabel(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glObjectPtrLabel(long arg0,java.lang.CharSequence arg1) {
		WRAPPER.glObjectPtrLabel(arg0,arg1);
	}


	/** GL46 */
	public static void glGetQueryBufferObjectuiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetQueryBufferObjectuiv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glTexBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.glTexBufferRange(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglSpecializeShader(int arg0,long arg1,int arg2,long arg3,long arg4) {
		WRAPPER.nglSpecializeShader(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetTexParameterIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTexParameterIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEvalCoord1dv(long arg0) {
		WRAPPER.nglEvalCoord1dv(arg0);
	}


	/** GL46 */
	public static void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nub(int arg0,byte arg1,byte arg2,byte arg3,byte arg4) {
		WRAPPER.glVertexAttrib4Nub(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3iv(int[] arg0) {
		WRAPPER.glSecondaryColor3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glSecondaryColor3iv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static boolean glIsQuery(int arg0) {
		return WRAPPER.glIsQuery(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSelectBuffer(java.nio.IntBuffer arg0) {
		WRAPPER.glSelectBuffer(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSelectBuffer(int[] arg0) {
		WRAPPER.glSelectBuffer(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetnUniformfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetnUniformfv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glGetnUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetnUniformfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormal3sv(long arg0) {
		WRAPPER.nglNormal3sv(arg0);
	}


	/** GL46 */
	public static void glGetNamedFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetNamedFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetNamedFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetNamedFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglGetnUniformuiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetnUniformuiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,long arg11) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.DoubleBuffer arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.FloatBuffer arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.IntBuffer arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ShortBuffer arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.ByteBuffer arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,double[] arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,float[] arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,short[] arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void glGetTextureSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int[] arg10) {
		WRAPPER.glGetTextureSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void nglCreateBuffers(int arg0,long arg1) {
		WRAPPER.nglCreateBuffers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nsv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib4Nsv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nsv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib4Nsv(arg0,arg1);
	}


	/** GL46 */
	public static void nglDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5) {
		WRAPPER.nglDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glVertex4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4dv(double[] arg0) {
		WRAPPER.glVertex4dv(arg0);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferSubData(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateNamedFramebufferSubData(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferSubData(int arg0,int[] arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateNamedFramebufferSubData(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glInvalidateNamedFramebufferSubData(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glInvalidateNamedFramebufferSubData(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void nglProgramUniform3dv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform3dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexsv(long arg0) {
		WRAPPER.nglIndexsv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetQueryObjectui(int arg0,int arg1) {
		return WRAPPER.glGetQueryObjectui(arg0,arg1);
	}


	/** GL46 */
	public static void glGetTransformFeedbacki_v(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetTransformFeedbacki_v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTransformFeedbacki_v(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetTransformFeedbacki_v(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetVertexArrayiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetVertexArrayiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetVertexArrayiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetVertexArrayiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos2dv(long arg0) {
		WRAPPER.nglRasterPos2dv(arg0);
	}


	/** GL46 */
	public static void glScissorArrayv(int arg0,int[] arg1) {
		WRAPPER.glScissorArrayv(arg0,arg1);
	}


	/** GL46 */
	public static void glScissorArrayv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glScissorArrayv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4Nubv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttrib4Nubv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4ubv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttrib4ubv(arg0,arg1);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirectCount(int arg0,int arg1,long arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glMultiDrawElementsIndirectCount(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirectCount(int arg0,int arg1,int[] arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glMultiDrawElementsIndirectCount(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirectCount(int arg0,int arg1,java.nio.IntBuffer arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glMultiDrawElementsIndirectCount(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glMultiDrawElementsIndirectCount(int arg0,int arg1,java.nio.ByteBuffer arg2,long arg3,int arg4,int arg5) {
		WRAPPER.glMultiDrawElementsIndirectCount(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetShaderiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetShaderiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static int glGetProgramResourceIndex(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glGetProgramResourceIndex(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static int glGetProgramResourceIndex(int arg0,int arg1,java.lang.CharSequence arg2) {
		return WRAPPER.glGetProgramResourceIndex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetVertexAttribIui(int arg0,int arg1) {
		return WRAPPER.glGetVertexAttribIui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniform2uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform2uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glVertex4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4fv(float[] arg0) {
		WRAPPER.glVertex4fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModeliv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glLightModeliv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModeliv(int arg0,int[] arg1) {
		WRAPPER.glLightModeliv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetTextureParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTextureParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTextureParameterIuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetNamedRenderbufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetNamedRenderbufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord4iv(long arg0) {
		WRAPPER.nglTexCoord4iv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetUniformLocation(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetUniformLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetUniformLocation(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glGetUniformLocation(arg0,arg1);
	}


	/** GLES32 */
	public static void glPrimitiveBoundingBox(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7) {
		WRAPPER.glPrimitiveBoundingBox(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP3ui(int arg0,int arg1) {
		WRAPPER.glVertexP3ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetTexParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTexParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTexParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos2fv(long arg0) {
		WRAPPER.nglRasterPos2fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiDrawElementsBaseVertex(int arg0,long arg1,int arg2,long arg3,int arg4,long arg5) {
		WRAPPER.nglMultiDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModelfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glLightModelfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glLightModelfv(int arg0,float[] arg1) {
		WRAPPER.glLightModelfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3sv(short[] arg0) {
		WRAPPER.glTexCoord3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glTexCoord3sv(arg0);
	}


	/** GL46, GLES32 */
	public static void glVertexAttribIFormat(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glVertexAttribIFormat(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glUniform2d(int arg0,double arg1,double arg2) {
		WRAPPER.glUniform2d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord4dv(long arg0) {
		WRAPPER.nglTexCoord4dv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2f(int arg0,float arg1,float arg2) {
		WRAPPER.glUniform2f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetMultisamplefv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetMultisamplefv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetMultisamplefv(arg0,arg1,arg2);
	}


	/** GLES30, GL46, GLES32 */
	public static void glGetInternalformativ(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetInternalformativ(arg0,arg1,arg2,arg3);
	}


	/** GLES30, GL46, GLES32 */
	public static void glGetInternalformativ(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetInternalformativ(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2i(int arg0,int arg1,int arg2) {
		WRAPPER.glUniform2i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferSubData(int arg0,long arg1,double[] arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,short[] arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,int[] arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferSubData(int arg0,long arg1,long[] arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBufferSubData(int arg0,long arg1,float[] arg2) {
		WRAPPER.glBufferSubData(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3fv(float[] arg0) {
		WRAPPER.glRasterPos3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glRasterPos3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetQueryObjectiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetQueryObjectiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiDrawElements(int arg0,long arg1,int arg2,long arg3,int arg4) {
		WRAPPER.nglMultiDrawElements(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsEnabled(int arg0) {
		return WRAPPER.glIsEnabled(arg0);
	}


	/** GL46 */
	public static long glGetInternalformati64(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetInternalformati64(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glVertexAttribP2uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,int[] arg3) {
		WRAPPER.glVertexAttribP2uiv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glUniform3d(int arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glUniform3d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3f(int arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glUniform3f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int nglGetFragDataLocation(int arg0,long arg1) {
		return WRAPPER.nglGetFragDataLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2fv(int arg0,float[] arg1) {
		WRAPPER.glUniform2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glUniform2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform3i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glUniform3i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3fv(float[] arg0) {
		WRAPPER.glSecondaryColor3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glSecondaryColor3fv(arg0);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void glClearDepthf(float arg0) {
		WRAPPER.glClearDepthf(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDisableVertexAttribArray(int arg0) {
		WRAPPER.glDisableVertexAttribArray(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexAttribP1uiv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglVertexAttribP1uiv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glUniform4d(int arg0,double arg1,double arg2,double arg3,double arg4) {
		WRAPPER.glUniform4d(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glTextureBarrier() {
		WRAPPER.glTextureBarrier();
	}


	/** GL40, GL46 */
	public static void glGetQueryIndexediv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetQueryIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glGetQueryIndexediv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetQueryIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int[] arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static java.lang.String glGetActiveSubroutineUniformName_String(int arg0,int arg1,int arg2,int arg3) {
		return WRAPPER.glGetActiveSubroutineUniformName_String(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static java.lang.String glGetActiveSubroutineUniformName_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveSubroutineUniformName_String(arg0,arg1,arg2);
	}


	/** GL46 */
	public static long glGetNamedBufferPointer(int arg0,int arg1) {
		return WRAPPER.glGetNamedBufferPointer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform2iv(int arg0,int[] arg1) {
		WRAPPER.glUniform2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4iv(java.nio.IntBuffer arg0) {
		WRAPPER.glVertex4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4iv(int[] arg0) {
		WRAPPER.glVertex4iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord4fv(long arg0) {
		WRAPPER.nglTexCoord4fv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glBindFragDataLocationIndexed(int arg0,int arg1,int arg2,java.lang.CharSequence arg3) {
		WRAPPER.glBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glBindFragDataLocationIndexed(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglDepthRangeArrayv(int arg0,int arg1,long arg2) {
		WRAPPER.nglDepthRangeArrayv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3dv(double[] arg0) {
		WRAPPER.glRasterPos3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glRasterPos3dv(arg0);
	}


	/** GL46 */
	public static void glGetQueryBufferObjecti64v(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetQueryBufferObjecti64v(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP4ui(int arg0,int arg1,int arg2) {
		WRAPPER.glMultiTexCoordP4ui(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnUniformdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetnUniformdv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnUniformdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetnUniformdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetTexParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetTexParameterfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetTexParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glInvalidateTexImage(int arg0,int arg1) {
		WRAPPER.glInvalidateTexImage(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glGetBooleanv(arg0,arg1);
	}


	/** GL46 */
	public static void glBindTextures(int arg0,int[] arg1) {
		WRAPPER.glBindTextures(arg0,arg1);
	}


	/** GL46 */
	public static void glBindTextures(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glBindTextures(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glEndQuery(int arg0) {
		WRAPPER.glEndQuery(arg0);
	}


	/** GL40, GL46 */
	public static void glUniform1d(int arg0,double arg1) {
		WRAPPER.glUniform1d(arg0,arg1);
	}


	/** GL46 */
	public static void glTextureParameteri(int arg0,int arg1,int arg2) {
		WRAPPER.glTextureParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1f(int arg0,float arg1) {
		WRAPPER.glUniform1f(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static boolean glGetBooleani(int arg0,int arg1) {
		return WRAPPER.glGetBooleani(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void glDisablei(int arg0,int arg1) {
		WRAPPER.glDisablei(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9) {
		WRAPPER.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL46 */
	public static void glTextureParameterf(int arg0,int arg1,float arg2) {
		WRAPPER.glTextureParameterf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniform1i(int arg0,int arg1) {
		WRAPPER.glUniform1i(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniformSubroutinesuiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniformSubroutinesuiv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniformSubroutinesuiv(int arg0,int[] arg1) {
		WRAPPER.glUniformSubroutinesuiv(arg0,arg1);
	}


	/** GL46 */
	public static void glBindBuffersBase(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glBindBuffersBase(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glBindBuffersBase(int arg0,int arg1,int[] arg2) {
		WRAPPER.glBindBuffersBase(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord4sv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord4sv(arg0,arg1);
	}


	/** GL46 */
	public static void nglClearTexSubImage(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10) {
		WRAPPER.nglClearTexSubImage(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
	}


	/** GL46 */
	public static void nglVertexAttribL4dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribL4dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetBufferParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetBufferParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glColor3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3dv(double[] arg0) {
		WRAPPER.glColor3dv(arg0);
	}


	/** GL46 */
	public static void glGetnConvolutionFilter(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetnConvolutionFilter(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnConvolutionFilter(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glGetnConvolutionFilter(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glScissorIndexedv(int arg0,int[] arg1) {
		WRAPPER.glScissorIndexedv(arg0,arg1);
	}


	/** GL46 */
	public static void glScissorIndexedv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glScissorIndexedv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglIndexiv(long arg0) {
		WRAPPER.nglIndexiv(arg0);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static int glGetSamplerParameterIui(int arg0,int arg1) {
		return WRAPPER.glGetSamplerParameterIui(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int nglGetDebugMessageLog(int arg0,int arg1,long arg2,long arg3,long arg4,long arg5,long arg6,long arg7) {
		return WRAPPER.nglGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform1uiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform1uiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP2uiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMultiTexCoordP2uiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glMultiTexCoordP2uiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glMultiTexCoordP2uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glTextureStorage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6) {
		WRAPPER.glTextureStorage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glTextureStorage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5) {
		WRAPPER.glTextureStorage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static java.nio.ByteBuffer glMapNamedBuffer_ByteBuffer(int arg0,int arg1) {
		return WRAPPER.glMapNamedBuffer_ByteBuffer(arg0,arg1);
	}


	/** GL46 */
	public static java.nio.ByteBuffer glMapNamedBuffer_ByteBuffer(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glMapNamedBuffer_ByteBuffer(arg0,arg1,arg2);
	}


	/** GL46 */
	public static java.nio.ByteBuffer glMapNamedBuffer_ByteBuffer(int arg0,int arg1,long arg2,java.nio.ByteBuffer arg3) {
		return WRAPPER.glMapNamedBuffer_ByteBuffer(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static long glGetNamedBufferParameteri64(int arg0,int arg1) {
		return WRAPPER.glGetNamedBufferParameteri64(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPushAttrib(int arg0) {
		WRAPPER.glPushAttrib(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetObjectLabel(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetObjectLabel(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glGetObjectLabel(int arg0,int arg1,int[] arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetObjectLabel(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetObjectLabel_String(int arg0,int arg1) {
		return WRAPPER.glGetObjectLabel_String(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static java.lang.String glGetObjectLabel_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetObjectLabel_String(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3bv(java.nio.ByteBuffer arg0) {
		WRAPPER.glSecondaryColor3bv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3fv(float[] arg0) {
		WRAPPER.glTexCoord3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glTexCoord3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3bv(java.nio.ByteBuffer arg0) {
		WRAPPER.glColor3bv(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglSamplerParameteriv(int arg0,int arg1,long arg2) {
		WRAPPER.nglSamplerParameteriv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI3iv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI3iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glBeginConditionalRender(int arg0,int arg1) {
		WRAPPER.glBeginConditionalRender(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform1uiv(int arg0,int[] arg1) {
		WRAPPER.glUniform1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform1uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glUniform1uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGenerateMipmap(int arg0) {
		WRAPPER.glGenerateMipmap(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBlendEquation(int arg0) {
		WRAPPER.glBlendEquation(arg0);
	}


	/** GL46, GLES32 */
	public static void glMemoryBarrier(int arg0) {
		WRAPPER.glMemoryBarrier(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribDivisor(int arg0,int arg1) {
		WRAPPER.glVertexAttribDivisor(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glTexStorage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5) {
		WRAPPER.glTexStorage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glGetVertexArrayIndexediv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetVertexArrayIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetVertexArrayIndexediv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetVertexArrayIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetnPolygonStipple(java.nio.ByteBuffer arg0) {
		WRAPPER.glGetnPolygonStipple(arg0);
	}


	/** GL46 */
	public static void glGetnPolygonStipple(int arg0,long arg1) {
		WRAPPER.glGetnPolygonStipple(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPixelMapuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglPixelMapuiv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4x2dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix4x2dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix4x2dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix4x2dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glClearColor(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glClearColor(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glSamplerParameterIuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord4sv(long arg0) {
		WRAPPER.nglTexCoord4sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilFunc(int arg0,int arg1,int arg2) {
		WRAPPER.glStencilFunc(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2i(int arg0,int arg1,int arg2) {
		WRAPPER.glVertexAttribI2i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiDrawArrays(int arg0,long arg1,long arg2,int arg3) {
		WRAPPER.nglMultiDrawArrays(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP2uiv(int arg0,int[] arg1) {
		WRAPPER.glTexCoordP2uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP2uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glTexCoordP2uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteSync(long arg0) {
		WRAPPER.glDeleteSync(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glVertexAttrib2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib2fv(int arg0,float[] arg1) {
		WRAPPER.glVertexAttrib2fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glRasterPos3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos3iv(int[] arg0) {
		WRAPPER.glRasterPos3iv(arg0);
	}


	/** GL40, GL46 */
	public static void glUniform2dv(int arg0,double[] arg1) {
		WRAPPER.glUniform2dv(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void glUniform2dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glUniform2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glSecondaryColor3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3dv(double[] arg0) {
		WRAPPER.glSecondaryColor3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3dv(double[] arg0) {
		WRAPPER.glTexCoord3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glTexCoord3dv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP4ui(int arg0,int arg1) {
		WRAPPER.glColorP4ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttrib4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttrib4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI3i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glVertexAttribI3i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static void nglGetPointerv(int arg0,long arg1) {
		WRAPPER.nglGetPointerv(arg0,arg1);
	}


	/** GL46 */
	public static void nglCreateVertexArrays(int arg0,long arg1) {
		WRAPPER.nglCreateVertexArrays(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static long glGetPointer(int arg0) {
		return WRAPPER.glGetPointer(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttrib2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttrib2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRotated(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glRotated(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glIndexubv(java.nio.ByteBuffer arg0) {
		WRAPPER.glIndexubv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRotatef(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glRotatef(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexAttribL3dv(int arg0,double[] arg1) {
		WRAPPER.glVertexAttribL3dv(arg0,arg1);
	}


	/** GL46 */
	public static void glVertexAttribL3dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glVertexAttribL3dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4x2fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix4x2fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix4x2fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix4x2fv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteSamplers(int arg0) {
		WRAPPER.glDeleteSamplers(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteSamplers(int[] arg0) {
		WRAPPER.glDeleteSamplers(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glDeleteSamplers(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteSamplers(arg0);
	}


	/** GL46, GLES32 */
	public static void nglDebugMessageControl(int arg0,int arg1,int arg2,int arg3,long arg4,boolean arg5) {
		WRAPPER.nglDebugMessageControl(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawArrays(int arg0,int[] arg1,int[] arg2) {
		WRAPPER.glMultiDrawArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiDrawArrays(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glMultiDrawArrays(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix2fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglVertexAttrib2fv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib2fv(arg0,arg1);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetAttribLocation(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glGetAttribLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetAttribLocation(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetAttribLocation(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2sv(short[] arg0) {
		WRAPPER.glWindowPos2sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glWindowPos2sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glCreateShader(int arg0) {
		return WRAPPER.glCreateShader(arg0);
	}


	/** GL46 */
	public static void nglCreateProgramPipelines(int arg0,long arg1) {
		WRAPPER.nglCreateProgramPipelines(arg0,arg1);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglSamplerParameterfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglSamplerParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glProgramUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,double[] arg3) {
		WRAPPER.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglGetTransformFeedbackiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetTransformFeedbackiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex2fv(long arg0) {
		WRAPPER.nglVertex2fv(arg0);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirect(int arg0,int[] arg1,int arg2,int arg3) {
		WRAPPER.glMultiDrawArraysIndirect(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirect(int arg0,java.nio.ByteBuffer arg1,int arg2,int arg3) {
		WRAPPER.glMultiDrawArraysIndirect(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirect(int arg0,long arg1,int arg2,int arg3) {
		WRAPPER.glMultiDrawArraysIndirect(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glMultiDrawArraysIndirect(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3) {
		WRAPPER.glMultiDrawArraysIndirect(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glVertexAttribLPointer(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3) {
		WRAPPER.glVertexAttribLPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void nglMultiTexCoordP1uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMultiTexCoordP1uiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetInternalformati64v(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetInternalformati64v(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix2dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix2dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix2dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static int glGetProgramStagei(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetProgramStagei(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI1i(int arg0,int arg1) {
		WRAPPER.glVertexAttribI1i(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetActiveAttrib(int arg0,int arg1,int arg2,long arg3,long arg4,long arg5,long arg6) {
		WRAPPER.nglGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL40, GL46 */
	public static void nglVertexP3uiv(int arg0,long arg1) {
		WRAPPER.nglVertexP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2i(int arg0,int arg1) {
		WRAPPER.glWindowPos2i(arg0,arg1);
	}


	/** GLES30, GL46, GLES32 */
	public static void glProgramBinary(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glProgramBinary(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2iv(int arg0,int[] arg1) {
		WRAPPER.glVertexAttribI2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexAttribI2iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2f(float arg0,float arg1) {
		WRAPPER.glWindowPos2f(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexAttribP2ui(int arg0,int arg1,boolean arg2,int arg3) {
		WRAPPER.glVertexAttribP2ui(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2d(double arg0,double arg1) {
		WRAPPER.glWindowPos2d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glTexCoord3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord3iv(int[] arg0) {
		WRAPPER.glTexCoord3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglRasterPos2iv(long arg0) {
		WRAPPER.nglRasterPos2iv(arg0);
	}


	/** GL46 */
	public static void glTextureParameterIi(int arg0,int arg1,int arg2) {
		WRAPPER.glTextureParameterIi(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedFramebufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetNamedFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetNamedFramebufferParameteriv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetNamedFramebufferParameteriv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix2dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib2dv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib2dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3s(short arg0,short arg1,short arg2) {
		WRAPPER.glWindowPos3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveAttrib_String(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3) {
		return WRAPPER.glGetActiveAttrib_String(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetActiveAttrib_String(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4) {
		return WRAPPER.glGetActiveAttrib_String(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetActiveAttrib(int arg0,int arg1,int[] arg2,int[] arg3,int[] arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetActiveAttrib(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertex2dv(long arg0) {
		WRAPPER.nglVertex2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3i(int arg0,int arg1,int arg2) {
		WRAPPER.glWindowPos3i(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3f(float arg0,float arg1,float arg2) {
		WRAPPER.glWindowPos3f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3d(double arg0,double arg1,double arg2) {
		WRAPPER.glWindowPos3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix2fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glUniformMatrix2fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix2fv(arg0,arg1,arg2);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawElementsIndirect(int arg0,int arg1,int[] arg2) {
		WRAPPER.glDrawElementsIndirect(arg0,arg1,arg2);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawElementsIndirect(int arg0,int arg1,long arg2) {
		WRAPPER.glDrawElementsIndirect(arg0,arg1,arg2);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawElementsIndirect(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glDrawElementsIndirect(arg0,arg1,arg2);
	}


	/** GL40, GL46, GLES32 */
	public static void glDrawElementsIndirect(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glDrawElementsIndirect(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static long glGetBufferPointer(int arg0,int arg1) {
		return WRAPPER.glGetBufferPointer(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glQueryCounter(int arg0,int arg1) {
		WRAPPER.glQueryCounter(arg0,arg1);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void nglGenTransformFeedbacks(int arg0,long arg1) {
		WRAPPER.nglGenTransformFeedbacks(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetVertexAttribIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetVertexAttribIiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int nglClientWaitSync(long arg0,int arg1,long arg2) {
		return WRAPPER.nglClientWaitSync(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos2s(short arg0,short arg1) {
		WRAPPER.glWindowPos2s(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointSize(float arg0) {
		WRAPPER.glPointSize(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glShaderSource(int arg0,org.lwjgl.PointerBuffer arg1,int[] arg2) {
		WRAPPER.glShaderSource(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glShaderSource(int arg0,java.lang.CharSequence... arg1) {
		WRAPPER.glShaderSource(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glShaderSource(int arg0,org.lwjgl.PointerBuffer arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glShaderSource(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glShaderSource(int arg0,java.lang.CharSequence arg1) {
		WRAPPER.glShaderSource(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform4fv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform4fv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glClearNamedFramebufferfv(int arg0,int arg1,int arg2,float[] arg3) {
		WRAPPER.glClearNamedFramebufferfv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glClearNamedFramebufferfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glClearNamedFramebufferfv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglObjectLabel(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglObjectLabel(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glTextureStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glTextureStorage2D(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormal3bv(long arg0) {
		WRAPPER.nglNormal3bv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9) {
		WRAPPER.nglTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL40, GL46, GLES32 */
	public static void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glCreateProgramPipelines(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateProgramPipelines(arg0);
	}


	/** GL46 */
	public static void glCreateProgramPipelines(int[] arg0) {
		WRAPPER.glCreateProgramPipelines(arg0);
	}


	/** GL46 */
	public static int glCreateProgramPipelines() {
		return WRAPPER.glCreateProgramPipelines();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3iv(int[] arg0) {
		WRAPPER.glWindowPos3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glWindowPos3iv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.nglReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5) {
		WRAPPER.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void nglObjectPtrLabel(long arg0,int arg1,long arg2) {
		WRAPPER.nglObjectPtrLabel(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4sv(short[] arg0) {
		WRAPPER.glVertex4sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glVertex4sv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4) {
		WRAPPER.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4d(int arg0,double arg1,double arg2,double arg3,double arg4) {
		WRAPPER.glVertexAttrib4d(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glTextureStorage1D(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glTextureStorage1D(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetVertexAttribdv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glGetVertexAttribdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetVertexAttribdv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glGetVertexAttribdv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetCompressedTexImage(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetCompressedTexImage(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglGetProgramiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetProgramiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos2iv(long arg0) {
		WRAPPER.nglWindowPos2iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4s(int arg0,short arg1,short arg2,short arg3,short arg4) {
		WRAPPER.glVertexAttrib4s(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP3uiv(int arg0,int[] arg1) {
		WRAPPER.glVertexP3uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glVertexP3uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glVertexP3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glArrayElement(int arg0) {
		WRAPPER.glArrayElement(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4usv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib4usv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib4usv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetVertexAttribi(int arg0,int arg1) {
		return WRAPPER.glGetVertexAttribi(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void nglGetObjectLabel(int arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.nglGetObjectLabel(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1iv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glMultiTexCoord1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1iv(int arg0,int[] arg1) {
		WRAPPER.glMultiTexCoord1iv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3uiv(long arg0) {
		WRAPPER.nglColor3uiv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glBlendColor(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glBlendColor(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglDrawPixels(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglDrawPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glTextureParameterfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glTextureParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glTextureParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glTextureParameterfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glVertexArrayElementBuffer(int arg0,int arg1) {
		WRAPPER.glVertexArrayElementBuffer(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglUniform4iv(int arg0,int arg1,long arg2) {
		WRAPPER.nglUniform4iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetUniformBlockIndex(int arg0,java.nio.ByteBuffer arg1) {
		return WRAPPER.glGetUniformBlockIndex(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static int glGetUniformBlockIndex(int arg0,java.lang.CharSequence arg1) {
		return WRAPPER.glGetUniformBlockIndex(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetLightfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetLightfv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetTextureParameterIui(int arg0,int arg1) {
		return WRAPPER.glGetTextureParameterIui(arg0,arg1);
	}


	/** GL46 */
	public static void glTextureStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glTextureStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glInvalidateBufferData(int arg0) {
		WRAPPER.glInvalidateBufferData(arg0);
	}


	/** GL46 */
	public static void glTransformFeedbackBufferBase(int arg0,int arg1,int arg2) {
		WRAPPER.glTransformFeedbackBufferBase(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void glProgramUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3) {
		WRAPPER.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglBufferSubData(int arg0,long arg1,long arg2,long arg3) {
		WRAPPER.nglBufferSubData(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static java.nio.ByteBuffer glMapNamedBufferRange_ByteBuffer(int arg0,long arg1,long arg2,int arg3,java.nio.ByteBuffer arg4) {
		return WRAPPER.glMapNamedBufferRange_ByteBuffer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static java.nio.ByteBuffer glMapNamedBufferRange_ByteBuffer(int arg0,long arg1,long arg2,int arg3) {
		return WRAPPER.glMapNamedBufferRange_ByteBuffer(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glVertexArrayAttribBinding(int arg0,int arg1,int arg2) {
		WRAPPER.glVertexArrayAttribBinding(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetVertexArrayiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetVertexArrayiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3fv(float[] arg0) {
		WRAPPER.glWindowPos3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glWindowPos3fv(arg0);
	}


	/** GL46 */
	public static void glClearNamedFramebufferfi(int arg0,int arg1,int arg2,float arg3,int arg4) {
		WRAPPER.glClearNamedFramebufferfi(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glNamedRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glNamedRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColorPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetVertexAttribfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribfv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetVertexAttribfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3x4fv(int arg0,boolean arg1,float[] arg2) {
		WRAPPER.glUniformMatrix3x4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniformMatrix3x4fv(int arg0,boolean arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glUniformMatrix3x4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMap1d(int arg0,double arg1,double arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglMap1d(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMap1f(int arg0,float arg1,float arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglMap1f(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.ByteBuffer arg7) {
		WRAPPER.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static boolean glUnmapBuffer(int arg0) {
		return WRAPPER.glUnmapBuffer(arg0);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static float glGetTexLevelParameterf(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTexLevelParameterf(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos2fv(long arg0) {
		WRAPPER.nglWindowPos2fv(arg0);
	}


	/** GL33, GL40, GL46 */
	public static void nglMultiTexCoordP4uiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglMultiTexCoordP4uiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46, GLES32 */
	public static int glGetTexLevelParameteri(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetTexLevelParameteri(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameteri(int arg0,int arg1) {
		WRAPPER.glPointParameteri(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPointParameterf(int arg0,float arg1) {
		WRAPPER.glPointParameterf(arg0,arg1);
	}


	/** GL46 */
	public static void glDepthRangeArrayv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glDepthRangeArrayv(arg0,arg1);
	}


	/** GL46 */
	public static void glDepthRangeArrayv(int arg0,double[] arg1) {
		WRAPPER.glDepthRangeArrayv(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,double[] arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,float[] arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,int[] arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,short[] arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.DoubleBuffer arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.FloatBuffer arg4) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.glGetnTexImage(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.nglReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexCoord3sv(long arg0) {
		WRAPPER.nglTexCoord3sv(arg0);
	}


	/** GL40, GL46 */
	public static void nglGetQueryIndexediv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetQueryIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglCreateTransformFeedbacks(int arg0,long arg1) {
		WRAPPER.nglCreateTransformFeedbacks(arg0,arg1);
	}


	/** GL46 */
	public static void glProgramUniform4dv(int arg0,int arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glProgramUniform4dv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glProgramUniform4dv(int arg0,int arg1,double[] arg2) {
		WRAPPER.glProgramUniform4dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void nglUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMap2d(int arg0,double arg1,double arg2,int arg3,int arg4,double arg5,double arg6,int arg7,int arg8,long arg9) {
		WRAPPER.nglMap2d(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3x4dv(int arg0,boolean arg1,java.nio.DoubleBuffer arg2) {
		WRAPPER.glUniformMatrix3x4dv(arg0,arg1,arg2);
	}


	/** GL40, GL46 */
	public static void glUniformMatrix3x4dv(int arg0,boolean arg1,double[] arg2) {
		WRAPPER.glUniformMatrix3x4dv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMap2f(int arg0,float arg1,float arg2,int arg3,int arg4,float arg5,float arg6,int arg7,int arg8,long arg9) {
		WRAPPER.nglMap2f(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3iv(int[] arg0) {
		WRAPPER.glColor3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3iv(java.nio.IntBuffer arg0) {
		WRAPPER.glColor3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetPixelMapuiv(int arg0,long arg1) {
		WRAPPER.nglGetPixelMapuiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glInitNames() {
		WRAPPER.glInitNames();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glTexCoord4dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTexCoord4dv(double[] arg0) {
		WRAPPER.glTexCoord4dv(arg0);
	}


	/** GLES30, GL46, GLES32 */
	public static void nglGetInternalformativ(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnCompressedTexImage(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetnCompressedTexImage(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnCompressedTexImage(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glGetnCompressedTexImage(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI2ui(int arg0,int arg1,int arg2) {
		WRAPPER.glVertexAttribI2ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPrimitiveRestartIndex(int arg0) {
		WRAPPER.glPrimitiveRestartIndex(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTranslatef(float arg0,float arg1,float arg2) {
		WRAPPER.glTranslatef(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPopMatrix() {
		WRAPPER.glPopMatrix();
	}


	/** GL40, GL46 */
	public static java.lang.String glGetActiveSubroutineName_String(int arg0,int arg1,int arg2,int arg3) {
		return WRAPPER.glGetActiveSubroutineName_String(arg0,arg1,arg2,arg3);
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int[] arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static void glGetActiveSubroutineName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL40, GL46 */
	public static java.lang.String glGetActiveSubroutineName_String(int arg0,int arg1,int arg2) {
		return WRAPPER.glGetActiveSubroutineName_String(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glTranslated(double arg0,double arg1,double arg2) {
		WRAPPER.glTranslated(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.nio.ByteBuffer glMapBufferRange_ByteBuffer(int arg0,long arg1,long arg2,int arg3,java.nio.ByteBuffer arg4) {
		return WRAPPER.glMapBufferRange_ByteBuffer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static java.nio.ByteBuffer glMapBufferRange_ByteBuffer(int arg0,long arg1,long arg2,int arg3) {
		return WRAPPER.glMapBufferRange_ByteBuffer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static boolean glIsFramebuffer(int arg0) {
		return WRAPPER.glIsFramebuffer(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3s(short arg0,short arg1,short arg2) {
		WRAPPER.glColor3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3f(float arg0,float arg1,float arg2) {
		WRAPPER.glColor3f(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glTexCoordP1ui(int arg0,int arg1) {
		WRAPPER.glTexCoordP1ui(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglGetLightiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetLightiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3fv(float[] arg0) {
		WRAPPER.glColor3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3fv(java.nio.FloatBuffer arg0) {
		WRAPPER.glColor3fv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3i(int arg0,int arg1,int arg2) {
		WRAPPER.glColor3i(arg0,arg1,arg2);
	}


	/** GL46 */
	public static double glGetnUniformd(int arg0,int arg1) {
		return WRAPPER.glGetnUniformd(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6) {
		WRAPPER.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderSource(int arg0,java.nio.IntBuffer arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetShaderSource(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetShaderSource(int arg0,int[] arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glGetShaderSource(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetShaderSource_String(int arg0,int arg1) {
		return WRAPPER.glGetShaderSource_String(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static java.lang.String glGetShaderSource_String(int arg0) {
		return WRAPPER.glGetShaderSource_String(arg0);
	}


	/** GL46, GLES32 */
	public static float glGetnUniformf(int arg0,int arg1) {
		return WRAPPER.glGetnUniformf(arg0,arg1);
	}


	/** GL46 */
	public static int glGetnUniformi(int arg0,int arg1) {
		return WRAPPER.glGetnUniformi(arg0,arg1);
	}


	/** GLES32 */
	public static float glGetnUniformi_float(int arg0,int arg1) {
		return WRAPPER.glGetnUniformi_float(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3b(byte arg0,byte arg1,byte arg2) {
		WRAPPER.glColor3b(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3d(double arg0,double arg1,double arg2) {
		WRAPPER.glColor3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetVertexAttribiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glGetVertexAttribiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetVertexAttribiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glStencilOpSeparate(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glRasterPos2sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glRasterPos2sv(short[] arg0) {
		WRAPPER.glRasterPos2sv(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,long arg3) {
		WRAPPER.nglUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glClearNamedFramebufferiv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glClearNamedFramebufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glClearNamedFramebufferiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glClearNamedFramebufferiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4s(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glColor4s(arg0,arg1,arg2,arg3);
	}


	/** GLES30, GL46, GLES32 */
	public static void glGetProgramBinary(int arg0,int[] arg1,int[] arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetProgramBinary(arg0,arg1,arg2,arg3);
	}


	/** GLES30, GL46, GLES32 */
	public static void glGetProgramBinary(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glGetProgramBinary(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4f(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glColor4f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glColor4i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetQueryObjectiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetQueryObjectiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetQueryObjectiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetQueryObjectiv(int arg0,int arg1,long arg2) {
		WRAPPER.glGetQueryObjectiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46 */
	public static void nglBindBuffersBase(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglBindBuffersBase(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glDepthRangeIndexed(int arg0,double arg1,double arg2) {
		WRAPPER.glDepthRangeIndexed(arg0,arg1,arg2);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP4uiv(int arg0,int[] arg1) {
		WRAPPER.glColorP4uiv(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void glColorP4uiv(int arg0,java.nio.IntBuffer arg1) {
		WRAPPER.glColorP4uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4b(byte arg0,byte arg1,byte arg2,byte arg3) {
		WRAPPER.glColor4b(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCopyPixels(int arg0,int arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glCopyPixels(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void nglNamedBufferStorage(int arg0,long arg1,long arg2,int arg3) {
		WRAPPER.nglNamedBufferStorage(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor4d(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glColor4d(arg0,arg1,arg2,arg3);
	}


	/** GL40, GLES30, GL46, GLES32 */
	public static void glBindTransformFeedback(int arg0,int arg1) {
		WRAPPER.glBindTransformFeedback(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static int glGetProgramPipelinei(int arg0,int arg1) {
		return WRAPPER.glGetProgramPipelinei(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteBuffers(int[] arg0) {
		WRAPPER.glDeleteBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteBuffers(int arg0) {
		WRAPPER.glDeleteBuffers(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glDeleteBuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glDeleteBuffers(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static boolean nglAreTexturesResident(int arg0,long arg1,long arg2) {
		return WRAPPER.nglAreTexturesResident(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3ui(int arg0,int arg1,int arg2) {
		WRAPPER.glColor3ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8) {
		WRAPPER.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL46 */
	public static void nglBufferStorage(int arg0,long arg1,long arg2,int arg3) {
		WRAPPER.nglBufferStorage(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL40, GL46 */
	public static void glNormalP3ui(int arg0,int arg1) {
		WRAPPER.glNormalP3ui(arg0,arg1);
	}


	/** GL46 */
	public static void glGetnSeparableFilter(int arg0,int arg1,int arg2,int arg3,long arg4,int arg5,long arg6,java.nio.ByteBuffer arg7) {
		WRAPPER.glGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46 */
	public static void glGetnSeparableFilter(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3,java.nio.ByteBuffer arg4,java.nio.ByteBuffer arg5) {
		WRAPPER.glGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttrib2sv(int arg0,long arg1) {
		WRAPPER.nglVertexAttrib2sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3ub(byte arg0,byte arg1,byte arg2) {
		WRAPPER.glColor3ub(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,int arg4,long arg5) {
		WRAPPER.nglGetnMinmax(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46, GLES32 */
	public static void glObjectLabel(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glObjectLabel(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glObjectLabel(int arg0,int arg1,java.lang.CharSequence arg2) {
		WRAPPER.glObjectLabel(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglBindImageTextures(int arg0,int arg1,long arg2) {
		WRAPPER.nglBindImageTextures(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3us(short arg0,short arg1,short arg2) {
		WRAPPER.glColor3us(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2d(double arg0,double arg1) {
		WRAPPER.glVertex2d(arg0,arg1);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5,int arg6) {
		WRAPPER.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,java.nio.ByteBuffer arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,java.nio.ShortBuffer arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,java.nio.IntBuffer arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,java.nio.ByteBuffer arg1,int arg2,int arg3,int arg4) {
		WRAPPER.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2f(float arg0,float arg1) {
		WRAPPER.glVertex2f(arg0,arg1);
	}


	/** GL46 */
	public static void glGetTransformFeedbackiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetTransformFeedbackiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetTransformFeedbackiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetTransformFeedbackiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglColor3usv(long arg0) {
		WRAPPER.nglColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2i(int arg0,int arg1) {
		WRAPPER.glVertex2i(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttribI4ubv(int arg0,java.nio.ByteBuffer arg1) {
		WRAPPER.glVertexAttribI4ubv(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4iv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glProgramUniform4iv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glProgramUniform4iv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelStoref(int arg0,float arg1) {
		WRAPPER.glPixelStoref(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormal3iv(long arg0) {
		WRAPPER.nglNormal3iv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglPixelMapfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglPixelMapfv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetQueryObjectuiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetQueryObjectuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex2s(short arg0,short arg1) {
		WRAPPER.glVertex2s(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glPixelStorei(int arg0,int arg1) {
		WRAPPER.glPixelStorei(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2) {
		WRAPPER.glGetInteger64i_v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glGetInteger64i_v(int arg0,int arg1,long[] arg2) {
		WRAPPER.glGetInteger64i_v(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetProgramResourceLocationIndex(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		return WRAPPER.glGetProgramResourceLocationIndex(arg0,arg1,arg2);
	}


	/** GL46 */
	public static int glGetProgramResourceLocationIndex(int arg0,int arg1,java.lang.CharSequence arg2) {
		return WRAPPER.glGetProgramResourceLocationIndex(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEvalCoord2dv(long arg0) {
		WRAPPER.nglEvalCoord2dv(arg0);
	}


	/** GL46 */
	public static void glGetTextureLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3) {
		WRAPPER.glGetTextureLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void glGetTextureLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glGetTextureLevelParameteriv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3d(double arg0,double arg1,double arg2) {
		WRAPPER.glVertex3d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3f(float arg0,float arg1,float arg2) {
		WRAPPER.glVertex3f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3i(int arg0,int arg1,int arg2) {
		WRAPPER.glVertex3i(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4fv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glProgramUniform4fv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glProgramUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glProgramUniform4fv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3sv(short[] arg0) {
		WRAPPER.glSecondaryColor3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glSecondaryColor3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFeedbackBuffer(int arg0,int arg1,long arg2) {
		WRAPPER.nglFeedbackBuffer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glCopyTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5) {
		WRAPPER.glCopyTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex3s(short arg0,short arg1,short arg2) {
		WRAPPER.glVertex3s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglWindowPos2dv(long arg0) {
		WRAPPER.nglWindowPos2dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3sv(java.nio.ShortBuffer arg0) {
		WRAPPER.glColor3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColor3sv(short[] arg0) {
		WRAPPER.glColor3sv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapfv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glGetPixelMapfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapfv(int arg0,long arg1) {
		WRAPPER.glGetPixelMapfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glGetPixelMapfv(int arg0,float[] arg1) {
		WRAPPER.glGetPixelMapfv(arg0,arg1);
	}


	/** GL46 */
	public static void nglProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4d(double arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glVertex4d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4f(float arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glVertex4f(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static void nglMultiDrawArraysIndirect(int arg0,long arg1,int arg2,int arg3) {
		WRAPPER.nglMultiDrawArraysIndirect(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4i(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glVertex4i(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glColorMaterial(int arg0,int arg1) {
		WRAPPER.glColorMaterial(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glValidateProgramPipeline(int arg0) {
		WRAPPER.glValidateProgramPipeline(arg0);
	}


	/** GL46, GLES32 */
	public static void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetProgramPipelineiv(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetProgramPipelineiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglVertexAttribI3uiv(int arg0,long arg1) {
		WRAPPER.nglVertexAttribI3uiv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7) {
		WRAPPER.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void nglGenSamplers(int arg0,long arg1) {
		WRAPPER.nglGenSamplers(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertex4s(short arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glVertex4s(arg0,arg1,arg2,arg3);
	}


	/** GL46 */
	public static int glCreateRenderbuffers() {
		return WRAPPER.glCreateRenderbuffers();
	}


	/** GL46 */
	public static void glCreateRenderbuffers(java.nio.IntBuffer arg0) {
		WRAPPER.glCreateRenderbuffers(arg0);
	}


	/** GL46 */
	public static void glCreateRenderbuffers(int[] arg0) {
		WRAPPER.glCreateRenderbuffers(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3ub(byte arg0,byte arg1,byte arg2) {
		WRAPPER.glSecondaryColor3ub(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglNamedBufferSubData(int arg0,long arg1,long arg2,long arg3) {
		WRAPPER.nglNamedBufferSubData(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glUniform2ui(int arg0,int arg1,int arg2) {
		WRAPPER.glUniform2ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3ui(int arg0,int arg1,int arg2) {
		WRAPPER.glSecondaryColor3ui(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static int glGetQueryObjecti(int arg0,int arg1) {
		return WRAPPER.glGetQueryObjecti(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void nglGetQueryObjecti64v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetQueryObjecti64v(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.FloatBuffer arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,short[] arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,float[] arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int[] arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ByteBuffer arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.ShortBuffer arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL46, GLES32 */
	public static void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.IntBuffer arg6) {
		WRAPPER.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
	}


	/** GL40, GL46, GLES32 */
	public static void glBlendEquationi(int arg0,int arg1) {
		WRAPPER.glBlendEquationi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3us(short arg0,short arg1,short arg2) {
		WRAPPER.glSecondaryColor3us(arg0,arg1,arg2);
	}


	/** GL46, GLES32 */
	public static boolean glIsProgramPipeline(int arg0) {
		return WRAPPER.glIsProgramPipeline(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1d(int arg0,double arg1) {
		WRAPPER.glVertexAttrib1d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormal3fv(long arg0) {
		WRAPPER.nglNormal3fv(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib1f(int arg0,float arg1) {
		WRAPPER.glVertexAttrib1f(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord1dv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib1s(int arg0,short arg1) {
		WRAPPER.glVertexAttrib1s(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetCompressedTextureImage(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetCompressedTextureImage(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEndConditionalRender() {
		WRAPPER.glEndConditionalRender();
	}


	/** GL46 */
	public static void nglGetnColorTable(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.nglGetnColorTable(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL46 */
	public static void glGetnUniformuiv(int arg0,int arg1,int[] arg2) {
		WRAPPER.glGetnUniformuiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void glGetnUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2) {
		WRAPPER.glGetnUniformuiv(arg0,arg1,arg2);
	}


	/** GLES32 */
	public static void glGetnUniformuiv(int arg0,int arg1,float[] arg2) {
		WRAPPER.glGetnUniformuiv(arg0,arg1,arg2);
	}


	/** GLES32 */
	public static void glGetnUniformuiv(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glGetnUniformuiv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglBufferData(int arg0,long arg1,long arg2,int arg3) {
		WRAPPER.nglBufferData(arg0,arg1,arg2,arg3);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,long arg4) {
		WRAPPER.nglProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglGetSynciv(long arg0,int arg1,int arg2,long arg3,long arg4) {
		WRAPPER.nglGetSynciv(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDeleteLists(int arg0,int arg1) {
		WRAPPER.glDeleteLists(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexEnvfv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexEnvfv(arg0,arg1,arg2);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGenSamplers(int[] arg0) {
		WRAPPER.glGenSamplers(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static void glGenSamplers(java.nio.IntBuffer arg0) {
		WRAPPER.glGenSamplers(arg0);
	}


	/** GL33, GL40, GLES30, GL46, GLES32 */
	public static int glGenSamplers() {
		return WRAPPER.glGenSamplers();
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform3iv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform3iv(arg0,arg1,arg2,arg3);
	}


	/** GLES20, GLES30, GL46, GLES32 */
	public static void nglGetShaderPrecisionFormat(int arg0,int arg1,long arg2,long arg3) {
		WRAPPER.nglGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglFogCoordPointer(int arg0,int arg1,long arg2) {
		WRAPPER.nglFogCoordPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3dv(java.nio.DoubleBuffer arg0) {
		WRAPPER.glWindowPos3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glWindowPos3dv(double[] arg0) {
		WRAPPER.glWindowPos3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3usv(java.nio.ShortBuffer arg0) {
		WRAPPER.glSecondaryColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColor3usv(short[] arg0) {
		WRAPPER.glSecondaryColor3usv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1d(double arg0) {
		WRAPPER.glEvalCoord1d(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetBufferParameteri(int arg0,int arg1) {
		return WRAPPER.glGetBufferParameteri(arg0,arg1);
	}


	/** GL46 */
	public static void glDebugMessageCallback(org.lwjgl.opengl.GLDebugMessageCallbackI arg0,long arg1) {
		WRAPPER.glDebugMessageCallback(arg0,arg1);
	}


	/** GLES32 */
	public static void glDebugMessageCallback(org.lwjgl.opengles.GLDebugMessageCallbackI arg0,long arg1) {
		WRAPPER.glDebugMessageCallback(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord1f(float arg0) {
		WRAPPER.glEvalCoord1f(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColorPointer(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColorPointer(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3) {
		WRAPPER.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColorPointer(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3) {
		WRAPPER.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColorPointer(int arg0,int arg1,int arg2,java.nio.ShortBuffer arg3) {
		WRAPPER.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glSecondaryColorPointer(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3) {
		WRAPPER.glSecondaryColorPointer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3) {
		WRAPPER.glVertexAttrib3f(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3d(int arg0,double arg1,double arg2,double arg3) {
		WRAPPER.glVertexAttrib3d(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelTransferf(int arg0,float arg1) {
		WRAPPER.glPixelTransferf(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glPixelTransferi(int arg0,int arg1) {
		WRAPPER.glPixelTransferi(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordPointer(int arg0,int arg1,long arg2) {
		WRAPPER.glFogCoordPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordPointer(int arg0,int arg1,java.nio.ByteBuffer arg2) {
		WRAPPER.glFogCoordPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordPointer(int arg0,int arg1,java.nio.FloatBuffer arg2) {
		WRAPPER.glFogCoordPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glFogCoordPointer(int arg0,int arg1,java.nio.ShortBuffer arg2) {
		WRAPPER.glFogCoordPointer(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1dv(int arg0,double[] arg1) {
		WRAPPER.glMultiTexCoord1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1dv(int arg0,java.nio.DoubleBuffer arg1) {
		WRAPPER.glMultiTexCoord1dv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglNormal3dv(long arg0) {
		WRAPPER.nglNormal3dv(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexEnviv(int arg0,int arg1,long arg2) {
		WRAPPER.nglTexEnviv(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7) {
		WRAPPER.nglTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}


	/** GL33, GL40, GL46, GLES32 */
	public static void nglGetSamplerParameterIiv(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetSamplerParameterIiv(arg0,arg1,arg2);
	}


	/** GL46 */
	public static void nglGetNamedBufferParameteri64v(int arg0,int arg1,long arg2) {
		WRAPPER.nglGetNamedBufferParameteri64v(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglMultiTexCoord1fv(int arg0,long arg1) {
		WRAPPER.nglMultiTexCoord1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib3s(int arg0,short arg1,short arg2,short arg3) {
		WRAPPER.glVertexAttrib3s(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void nglDeleteQueries(int arg0,long arg1) {
		WRAPPER.nglDeleteQueries(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultTransposeMatrixf(java.nio.FloatBuffer arg0) {
		WRAPPER.glMultTransposeMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultTransposeMatrixf(float[] arg0) {
		WRAPPER.glMultTransposeMatrixf(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2d(double arg0,double arg1) {
		WRAPPER.glEvalCoord2d(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glEvalCoord2f(float arg0,float arg1) {
		WRAPPER.glEvalCoord2f(arg0,arg1);
	}


	/** GL33, GL40, GL46 */
	public static void nglTexCoordP2uiv(int arg0,long arg1) {
		WRAPPER.nglTexCoordP2uiv(arg0,arg1);
	}


	/** GL46 */
	public static void nglGetVertexArrayIndexediv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetVertexArrayIndexediv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.ShortBuffer arg4) {
		WRAPPER.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4) {
		WRAPPER.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4) {
		WRAPPER.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.ByteBuffer arg4) {
		WRAPPER.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glVertexAttrib2f(int arg0,float arg1,float arg2) {
		WRAPPER.glVertexAttrib2f(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static float glGetTexParameterf(int arg0,int arg1) {
		return WRAPPER.glGetTexParameterf(arg0,arg1);
	}


	/** GL40, GL46 */
	public static void nglGetProgramStageiv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglGetProgramStageiv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2d(int arg0,double arg1,double arg2) {
		WRAPPER.glVertexAttrib2d(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static int glGetTexParameteri(int arg0,int arg1) {
		return WRAPPER.glGetTexParameteri(arg0,arg1);
	}


	/** GL46, GLES32 */
	public static void glCopyImageSubData(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,int arg11,int arg12,int arg13,int arg14) {
		WRAPPER.glCopyImageSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14);
	}


	/** GL46 */
	public static void nglViewportIndexedfv(int arg0,long arg1) {
		WRAPPER.nglViewportIndexedfv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultTransposeMatrixd(double[] arg0) {
		WRAPPER.glMultTransposeMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultTransposeMatrixd(java.nio.DoubleBuffer arg0) {
		WRAPPER.glMultTransposeMatrixd(arg0);
	}


	/** GL33, GL32, GL40, GLES30, GL46, GLES32 */
	public static boolean glIsSync(long arg0) {
		return WRAPPER.glIsSync(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void nglTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8) {
		WRAPPER.nglTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glFinish() {
		WRAPPER.glFinish();
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2sv(int arg0,short[] arg1) {
		WRAPPER.glVertexAttrib2sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2sv(int arg0,java.nio.ShortBuffer arg1) {
		WRAPPER.glVertexAttrib2sv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3) {
		WRAPPER.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glVertexAttrib2s(int arg0,short arg1,short arg2) {
		WRAPPER.glVertexAttrib2s(arg0,arg1,arg2);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1fv(int arg0,float[] arg1) {
		WRAPPER.glMultiTexCoord1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glMultiTexCoord1fv(int arg0,java.nio.FloatBuffer arg1) {
		WRAPPER.glMultiTexCoord1fv(arg0,arg1);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void nglEvalCoord2fv(long arg0) {
		WRAPPER.nglEvalCoord2fv(arg0);
	}


	/** GL46, GLES32 */
	public static void nglProgramUniform3fv(int arg0,int arg1,int arg2,long arg3) {
		WRAPPER.nglProgramUniform3fv(arg0,arg1,arg2,arg3);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glActiveTexture(int arg0) {
		WRAPPER.glActiveTexture(arg0);
	}


	/** GL46, GLES32 */
	public static void glVertexAttribFormat(int arg0,int arg1,int arg2,boolean arg3,int arg4) {
		WRAPPER.glVertexAttribFormat(arg0,arg1,arg2,arg3,arg4);
	}


	/** GL33, GL32, GL40, GL46 */
	public static void glDisableClientState(int arg0) {
		WRAPPER.glDisableClientState(arg0);
	}


	/** GL33, GL32, GL40, GLES20, GLES30, GL46, GLES32 */
	public static void glLinkProgram(int arg0) {
		WRAPPER.glLinkProgram(arg0);
	}


	public static void checkError(String message) {
		WRAPPER.checkError(message);
	}
	public static void checkError() {
		WRAPPER.checkError("");
	}
	public static boolean isGLES() {
		return WRAPPER.isGLES();
	}
	public static boolean isGL() {
		return WRAPPER.isGL();
	}
}
