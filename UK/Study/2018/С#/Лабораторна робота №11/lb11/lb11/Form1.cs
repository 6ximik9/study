﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb11
{
    public partial class Form1 : Form
    {
        private int x1, y1, x2, y2;

        private void Form1_Load(object sender, EventArgs e)
        {
            x1 = ClientSize.Width / 2;
            y1 = ClientSize.Height / 2;
            a = 150;
            fi = -0.5;
            t = Math.Tan(fi);
            x2 = x1 + (int)((3 * a * t) / (1 + t * t * t));
            y2 = y1 - (int)((3 * a * t * t) / (1 + t * t * t));
            BackColor = Color.Black;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            for (int i = 0; i < 30; i++)
            {
                g.DrawEllipse(pen, (x2-100)*i, (y2-50)*10, 3, 3);
                
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            fi += 0.01;
            t = Math.Tan(fi);
            x2 = (x1 - (int)Math.Tan(a));
            y2 = y1 - (int)((3 * a *   t) / (1 + t *   t));
            Invalidate();
        }

        private double a, t, fi;
        private Pen pen = new Pen(Color.White, 2);
        public Form1()
        {
            InitializeComponent();
        }
    }
}
