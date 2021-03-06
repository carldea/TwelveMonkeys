/*
 * Copyright (c) 2017, Harald Kuhr
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.twelvemonkeys.imageio.plugins.bmp;

import com.twelvemonkeys.imageio.spi.ImageWriterSpiBase;

import javax.imageio.ImageTypeSpecifier;
import java.awt.image.BufferedImage;
import java.util.Locale;

/**
 * ICOImageWriterSpi
 */
public final class ICOImageWriterSpi extends ImageWriterSpiBase {
    public ICOImageWriterSpi() {
        super(new ICOProviderInfo());
    }

    @Override
    public boolean canEncodeImage(final ImageTypeSpecifier type) {
        // TODO: Support more types, as time permits.
        // NOTE: We do support more types, if writing using PNG compression
        return type.getBufferedImageType() == BufferedImage.TYPE_4BYTE_ABGR;
    }

    @Override
    public ICOImageWriter createWriterInstance(final Object extension) {
        return new ICOImageWriter(this);
    }

    @Override
    public String getDescription(final Locale locale) {
        return "Windows Icon Format (ICO) Writer";
    }
}
